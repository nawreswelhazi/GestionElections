package ProjetElection.ProjetElection.Services;


import ProjetElection.ProjetElection.Entities.Politique;
import ProjetElection.ProjetElection.Repositories.PolitiqueRepository;
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
public class PolitiqueService {
    @Autowired
    private PolitiqueRepository PR;

    public ResponseEntity<Politique> addActivite(Politique P1){
        Optional<Politique> res = PR.findByName(P1.getNom());
        if (res.isPresent())
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        Politique P2 = PR.save(P1);
        return new ResponseEntity(P1, HttpStatus.CREATED);
    }

    public ResponseEntity<List<Politique>> getAllActivites()
    {
        List<Politique> lst1=PR.findAll();
        if(lst1.isEmpty())
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        return new ResponseEntity(lst1,HttpStatus.OK);
    }

    public ResponseEntity<?> getOneActivite(Long id)
    {
        Optional<Politique> corruption1 = PR.findById(id);
        //if(team.isEmpty())
        //   return new ResponseEntity(HttpStatus.NOT_FOUND);
        //return new ResponseEntity(team,HttpStatus.OK);
        //or
        return corruption1.map(x->ResponseEntity.ok().body(corruption1))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }






    public Map<String, Boolean> deleteActivite(Long id)
            throws ResourceNotFoundException {
        Politique Poli = PR.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("activite not found"));

        PR.deleteById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }



    public ResponseEntity<Politique> updateactivite(Long id,Politique P1) throws ResourceNotFoundException {
        Politique P2 = PR.findById(id).orElseThrow(() -> new ResourceNotFoundException("activite introuvable "));
        P2.setResultatAtteint(P1.getResultatAtteint());
        P2.setDateDebut(P1.getDateDebut());
        P2.setDateFin(P1.getDateFin());
        P2.setTauxOrganisation(P1.getTauxOrganisation());
        P2.setVisibiliteActivite(P1.getVisibiliteActivite());
        P2.setNom(P1.getNom());
        P2.setSupport(P1.getSupport());
        P2.setVisibiliteCandidat(P1.getVisibiliteCandidat());
        PR.save(P2);
        return new ResponseEntity(P2,HttpStatus.OK);
    }








}

