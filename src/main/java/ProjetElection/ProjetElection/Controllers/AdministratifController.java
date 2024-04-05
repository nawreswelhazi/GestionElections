package ProjetElection.ProjetElection.Controllers;


import ProjetElection.ProjetElection.Entities.Administratif;
import ProjetElection.ProjetElection.Services.AdministratifService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200" , allowedHeaders="*")
@RequestMapping("/ActivitesAdministratifs")
public class AdministratifController {
    @Autowired
    private AdministratifService AS;
    private final Logger log= LoggerFactory.getLogger(Administratif.class);

    @PostMapping("/newActivite")
    public ResponseEntity<Administratif> addNewTeam(@Valid @RequestBody Administratif A1)
    {
        return AS.addActiviteAdministratif(A1);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Administratif>> getAllTeams()
    {
        return AS.getAllActivites();
    }
    @GetMapping("/Activite/{id}")
    public ResponseEntity<?> getActiviteById(@PathVariable Long id)
    {
        return AS.getOneActivite(id);
    }

    /*@DeleteMapping("/Activitedelete/{id}")
    public void deleteActivite( @PathVariable Long id)
    {
        AS.deleteActivite(id);
    }*/
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateactivite(@PathVariable Long id, @Valid @RequestBody Administratif A1)
    {
        return AS.updateactivite(id, A1);
    }

    @DeleteMapping("/Delete/{id}")
    public Map<String, Boolean> deleteactivite(@PathVariable Long id)
    {
        return AS.deleteActivite(id);
    }





}
