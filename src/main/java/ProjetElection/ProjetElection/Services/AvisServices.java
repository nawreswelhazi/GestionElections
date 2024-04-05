package ProjetElection.ProjetElection.Services;

import ProjetElection.ProjetElection.Entities.Avis;
import ProjetElection.ProjetElection.Repositories.AvisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AvisServices {

    @Autowired
    private AvisRepository ar;

    public ResponseEntity<Avis> addAvis(Avis t){
        Avis T2 =  ar.save(t);
        return new ResponseEntity<>(T2,HttpStatus.CREATED);
    }

    public ResponseEntity<List<Avis>> getall(){

        List<Avis> lst1 = ar.findAll();
        if (lst1.isEmpty())
            return new  ResponseEntity(HttpStatus.NO_CONTENT);
        return new ResponseEntity(lst1,HttpStatus.OK);
    }
/*
    public ResponseEntity<?> getAvis(Long id, Long id2){
        Optional<Avis> t =ar.findById2(id,id2);
        if (!(t.isPresent()))
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        return new ResponseEntity(t,HttpStatus.OK);
    }

    public ResponseEntity deleteAvis(Long id)
    {
        Optional <Avis> t = ar.findById(id);
        if (!(t.isPresent()))
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        ar.deleteById(id);
        return new ResponseEntity(t,HttpStatus.OK);
    }

    public ResponseEntity<Avis> updateAvisNote(Long id , Avis newAvis)
    {
        Optional<Avis> t = ar.findById(id);
        if (!(t.isPresent()))
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        Avis t2 = t.get();
        t2.setNote(newAvis.getNote());
        Avis t3=ar.save(t2);
        return new ResponseEntity(t3,HttpStatus.OK);
    }*/

}
