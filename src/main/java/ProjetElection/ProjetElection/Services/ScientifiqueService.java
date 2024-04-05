package ProjetElection.ProjetElection.Services;


import ProjetElection.ProjetElection.Entities.Scientifique;
import ProjetElection.ProjetElection.Repositories.ScientifiqueRepository;
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
public class ScientifiqueService {
    @Autowired
    private ScientifiqueRepository SR;

    public ResponseEntity<Scientifique> addActivite(Scientifique S1){
        Optional<Scientifique> res = SR.findByName(S1.getNom());
        if (res.isPresent())
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        Scientifique S2 = SR.save(S1);
        return new ResponseEntity(S1, HttpStatus.CREATED);
    }

    public ResponseEntity<List<Scientifique>> getAllActivites()
    {
        List<Scientifique> lst1=SR.findAll();
        if(lst1.isEmpty())
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        return new ResponseEntity(lst1,HttpStatus.OK);
    }

    public ResponseEntity<?> getOneActivite(Long id)
    {
        Optional<Scientifique> scientifique1 = SR.findById(id);
        //if(team.isEmpty())
        //   return new ResponseEntity(HttpStatus.NOT_FOUND);
        //return new ResponseEntity(team,HttpStatus.OK);
        //or
        return scientifique1.map(x->ResponseEntity.ok().body(scientifique1))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }






    public Map<String, Boolean> deleteActivite(Long id)
            throws ResourceNotFoundException {
       Scientifique Scien = SR.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("activite not found"));

        SR.deleteById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }



    public ResponseEntity<Scientifique> updateactivite(Long id,Scientifique S1) throws ResourceNotFoundException {
        Scientifique S2 = SR.findById(id).orElseThrow(() -> new ResourceNotFoundException("activite introuvable "));
        S2.setBudget(S1.getBudget());
        S2.setDateDebut(S1.getDateDebut());
        S2.setDateFin(S1.getDateFin());
        S2.setNbPublic(S1.getNbPublic());
        S2.setType(S1.getType());
        S2.setTauxdorganisation(S1.getTauxdorganisation());
        S2.setNom(S1.getNom());
        S2.setSupport(S1.getSupport());
        SR.save(S2);
        return new ResponseEntity(S2,HttpStatus.OK);
    }








}


