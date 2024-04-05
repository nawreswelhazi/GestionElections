package ProjetElection.ProjetElection.Services;

import ProjetElection.ProjetElection.Entities.Corruption;
import ProjetElection.ProjetElection.Entities.Electeur;
import ProjetElection.ProjetElection.Repositories.ElecteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ElecteurServices {
    @Autowired
    private ElecteurRepository er;

    public ResponseEntity<Electeur> addElecteur(Electeur t) {
        if (er.findByUserName(t.getUsername()).isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Electeur T2 = er.save(t);
        return new ResponseEntity<>(T2, HttpStatus.CREATED);
    }

    public ResponseEntity<List<Electeur>> getall() {

        List<Electeur> lst1 = er.findAll();
        if (lst1.isEmpty())
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        return new ResponseEntity(lst1, HttpStatus.OK);
    }

    public ResponseEntity<?> getoneelecteur(String username) {
        Optional<Electeur> t = er.findByUserName(username);
        if (!t.isPresent())
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        return new ResponseEntity(t, HttpStatus.OK);

    }

    public ResponseEntity deleteElecteur(String username)
    {
        Optional <Electeur> t = er.findByUserName(username);
        if (!(t.isPresent()))
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        er.deleteByUserName(username);
        return new ResponseEntity(t,HttpStatus.OK);
    }

    public ResponseEntity<Electeur> updateElecteur(Long id, Electeur electeurnew) {
        Optional<Electeur> t = er.findById(id);
        if (!t.isPresent())
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        Electeur t2 = t.get();
        t2.setNom(electeurnew.getNom());
        t2.setPrenom(electeurnew.getPrenom());
        Electeur t3 = er.save(t2);
        return new ResponseEntity(t3, HttpStatus.OK);
    }
}


