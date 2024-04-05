package ProjetElection.ProjetElection.Services;

import ProjetElection.ProjetElection.Entities.Administratif;
import ProjetElection.ProjetElection.Repositories.AdministratifRepository;
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
public class AdministratifService {
    @Autowired
    private AdministratifRepository AR;

    public ResponseEntity<Administratif> addActiviteAdministratif(Administratif A1){
        Optional<Administratif> res = AR.findByName(A1.getNom());
        if (res.isPresent())
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        Administratif A2 = AR.save(A1);
        return new ResponseEntity(A2, HttpStatus.CREATED);
    }

    public ResponseEntity<List<Administratif>> getAllActivites()
    {
        List<Administratif> lst1=AR.findAll();
        if(lst1.isEmpty())
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        return new ResponseEntity(lst1,HttpStatus.OK);
    }

    public ResponseEntity<?> getOneActivite(Long id)
    {
        Optional<Administratif> administratif1 = AR.findById(id);
        //if(team.isEmpty())
        //   return new ResponseEntity(HttpStatus.NOT_FOUND);
        //return new ResponseEntity(team,HttpStatus.OK);
        //or
        return administratif1.map(x->ResponseEntity.ok().body(administratif1))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }


    public Map<String, Boolean> deleteActivite(Long id)
            throws ResourceNotFoundException {
        Administratif admin = AR.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("activite not found"));

        AR.deleteById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }



    public ResponseEntity<Administratif> updateactivite(Long id,Administratif A1) throws ResourceNotFoundException {
        Administratif A2 = AR.findById(id).orElseThrow(() -> new ResourceNotFoundException("activite introuvable "));
        A2.setAnneesExperience(A1.getAnneesExperience());
            A2.setPoste(A1.getPoste());
            A2.setNom(A1.getNom());
            A2.setSupport(A1.getSupport());
            AR.save(A2);
            return new ResponseEntity(A2,HttpStatus.OK);
        }








}
