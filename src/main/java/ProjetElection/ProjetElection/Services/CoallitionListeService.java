package ProjetElection.ProjetElection.Services;

import ProjetElection.ProjetElection.Entities.Coalition;
import ProjetElection.ProjetElection.Entities.Electeur;
import ProjetElection.ProjetElection.Repositories.CoallitionListeRepository;
import ProjetElection.ProjetElection.Repositories.ElecteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoallitionListeService {

    @Autowired
    private CoallitionListeRepository coallrepos;

    public ResponseEntity<Coalition> addCoalition(Coalition t) {
        if (coallrepos.findById(t.getId()).isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Coalition T2 = coallrepos.save(t);
        return new ResponseEntity<>(T2, HttpStatus.CREATED);
    }

    public ResponseEntity<List<Coalition>> getall() {

        List<Coalition> lst1 = coallrepos.findAll();
        if (lst1.isEmpty())
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        return new ResponseEntity(lst1, HttpStatus.OK);
    }

    public ResponseEntity<?> getoneCoalition(Long id ) {
        Optional<Coalition> t = coallrepos.findById(id);
        if (!t.isPresent())
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        return new ResponseEntity(t, HttpStatus.OK);

    }

    public ResponseEntity deleteCoalition(Long id)
    {
        Optional <Coalition> t = coallrepos.findById(id);
        if (!(t.isPresent()))
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        coallrepos.deleteById(id);
        return new ResponseEntity(t,HttpStatus.OK);
    }

    public ResponseEntity<Coalition> updateCoalition(Long id, Coalition newcoal){
        Optional <Coalition> t = coallrepos.findById(id);
        if (!t.isPresent())
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        Coalition t2 = t.get();
        t2.setTeteDeliste(newcoal.getTeteDeliste());
        Coalition t3 = coallrepos.save(t2);
        return new ResponseEntity(t3, HttpStatus.OK);
    }
}
