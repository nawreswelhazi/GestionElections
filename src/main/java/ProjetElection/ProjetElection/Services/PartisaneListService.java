package ProjetElection.ProjetElection.Services;

import ProjetElection.ProjetElection.Entities.Partisane;
import ProjetElection.ProjetElection.Repositories.PartisaneListeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartisaneListService {

    @Autowired
    private PartisaneListeRepository coallrepos;

    public ResponseEntity<Partisane> addPartisane(Partisane t) {
        if (coallrepos.findById(t.getId()).isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Partisane T2 = coallrepos.save(t);
        return new ResponseEntity<>(T2, HttpStatus.CREATED);
    }

    public ResponseEntity<List<Partisane>> getall() {

        List<Partisane> lst1 = coallrepos.findAll();
        if (lst1.isEmpty())
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        return new ResponseEntity(lst1, HttpStatus.OK);
    }

    public ResponseEntity<?> getonePartisane(Long id ) {
        Optional<Partisane> t = coallrepos.findById(id);
        if (!t.isPresent())
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        return new ResponseEntity(t, HttpStatus.OK);

    }

    public ResponseEntity deletePartisane(Long id)
    {
        Optional <Partisane> t = coallrepos.findById(id);
        if (!(t.isPresent()))
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        coallrepos.deleteById(id);
        return new ResponseEntity(t,HttpStatus.OK);
    }

    public ResponseEntity<Partisane> updatePartisane(Long id, Partisane newcoal){
        Optional <Partisane> t = coallrepos.findById(id);
        if (!t.isPresent())
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        Partisane t2 = t.get();
        t2.setTeteDeliste(newcoal.getTeteDeliste());
        Partisane t3 = coallrepos.save(t2);
        return new ResponseEntity(t3, HttpStatus.OK);
    }
}
