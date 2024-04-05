package ProjetElection.ProjetElection.Services;

import ProjetElection.ProjetElection.Entities.Independante;
import ProjetElection.ProjetElection.Repositories.CoallitionListeRepository;
import ProjetElection.ProjetElection.Repositories.IndependanteListeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IndependanteListeService {

    @Autowired
    private IndependanteListeRepository coallrepos;

    public ResponseEntity<Independante> addIndependante(Independante t) {
        if (coallrepos.findById(t.getId()).isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Independante T2 = coallrepos.save(t);
        return new ResponseEntity<>(T2, HttpStatus.CREATED);
    }

    public ResponseEntity<List<Independante>> getall() {

        List<Independante> lst1 = coallrepos.findAll();
        if (lst1.isEmpty())
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        return new ResponseEntity(lst1, HttpStatus.OK);
    }

    public ResponseEntity<?> getoneIndependante(Long id ) {
        Optional<Independante> t = coallrepos.findById(id);
        if (!t.isPresent())
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        return new ResponseEntity(t, HttpStatus.OK);

    }

    public ResponseEntity deleteIndependante(Long id)
    {
        Optional <Independante> t = coallrepos.findById(id);
        if (!(t.isPresent()))
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        coallrepos.deleteById(id);
        return new ResponseEntity(t,HttpStatus.OK);
    }

    public ResponseEntity<Independante> updateIndependante(Long id, Independante newcoal){
        Optional <Independante> t = coallrepos.findById(id);
        if (!t.isPresent())
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        Independante t2 = t.get();
        t2.setTeteDeliste(newcoal.getTeteDeliste());
        Independante t3 = coallrepos.save(t2);
        return new ResponseEntity(t3, HttpStatus.OK);
    }
}
