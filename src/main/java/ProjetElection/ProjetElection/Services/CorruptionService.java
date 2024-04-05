package ProjetElection.ProjetElection.Services;


import ProjetElection.ProjetElection.Entities.Corruption;
import ProjetElection.ProjetElection.Repositories.CorruptionRepository;
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
public class CorruptionService {
    @Autowired
    private CorruptionRepository CR;

    public ResponseEntity<Corruption> addActivite(Corruption C1){
        Optional<Corruption> res = CR.findByName(C1.getNom());
        if (res.isPresent())
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        Corruption C2 = CR.save(C1);
        return new ResponseEntity(C1, HttpStatus.CREATED);
    }

    public ResponseEntity<List<Corruption>> getAllActivites()
    {
        List<Corruption> lst1=CR.findAll();
        if(lst1.isEmpty())
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        return new ResponseEntity(lst1,HttpStatus.OK);
    }

    public ResponseEntity<?> getOneActivite(Long id)
    {
        Optional<Corruption> corruption1 = CR.findById(id);
        //if(team.isEmpty())
        //   return new ResponseEntity(HttpStatus.NOT_FOUND);
        //return new ResponseEntity(team,HttpStatus.OK);
        //or
        return corruption1.map(x->ResponseEntity.ok().body(corruption1))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }


    public Map<String, Boolean> deleteActivite(Long id)
            throws ResourceNotFoundException {
        Corruption corrup = CR.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("activite not found"));

        CR.deleteById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }



    public ResponseEntity<Corruption> updateactivite(Long id,Corruption C1) throws ResourceNotFoundException {
        Corruption C2 = CR.findById(id).orElseThrow(() -> new ResourceNotFoundException("activite introuvable "));
        C2.setTauxDepreciation(C1.getTauxDepreciation());
        C2.setNom(C1.getNom());
        C2.setSupport(C1.getSupport());
        CR.save(C2);
        return new ResponseEntity(C2,HttpStatus.OK);
    }








}
