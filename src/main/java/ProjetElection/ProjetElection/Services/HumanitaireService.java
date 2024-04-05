package ProjetElection.ProjetElection.Services;


import ProjetElection.ProjetElection.Entities.Humanitaire;
import ProjetElection.ProjetElection.Repositories.HumanitaireRepository;
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
public class HumanitaireService {
    @Autowired
    private HumanitaireRepository HR;

    public ResponseEntity<Humanitaire> addActivite(Humanitaire H1){
        Optional<Humanitaire> res = HR.findByName(H1.getNom());
        if (res.isPresent())
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        Humanitaire H2 = HR.save(H1);
        return new ResponseEntity(H1, HttpStatus.CREATED);
    }

    public ResponseEntity<List<Humanitaire>> getAllActivites()
    {
        List<Humanitaire> lst1=HR.findAll();
        if(lst1.isEmpty())
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        return new ResponseEntity(lst1,HttpStatus.OK);
    }

    public ResponseEntity<?> getOneActivite(Long id)
    {
        Optional<Humanitaire> corruption1 = HR.findById(id);
        //if(team.isEmpty())
        //   return new ResponseEntity(HttpStatus.NOT_FOUND);
        //return new ResponseEntity(team,HttpStatus.OK);
        //or
        return corruption1.map(x->ResponseEntity.ok().body(corruption1))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }






    public Map<String, Boolean> deleteActivite(Long id)
            throws ResourceNotFoundException {
        Humanitaire human = HR.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("activite not found"));

        HR.deleteById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    public ResponseEntity<Humanitaire> updateactivite(Long id,Humanitaire H1) throws ResourceNotFoundException {
        Humanitaire H2 = HR.findById(id).orElseThrow(() -> new ResourceNotFoundException("activite introuvable "));
        H2.setCauseHumanitaire(H1.getCauseHumanitaire());
        H2.setDateDebut(H1.getDateDebut());
        H2.setDateFin(H1.getDateFin());
        H2.setNbParticipants(H1.getNbParticipants());
        H2.setNom(H1.getNom());
        H2.setSupport(H1.getSupport());
        H2.setFond(H1.getFond());
        H2.setProvocation(H1.isProvocation());
        HR.save(H2);
        return new ResponseEntity(H2,HttpStatus.OK);
    }








}
