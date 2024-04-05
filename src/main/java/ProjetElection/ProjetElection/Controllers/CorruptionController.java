package ProjetElection.ProjetElection.Controllers;


import ProjetElection.ProjetElection.Entities.Corruption;
import ProjetElection.ProjetElection.Services.CorruptionService;
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
@RequestMapping("/ActivitesCorruption")
public class CorruptionController {
    @Autowired
    private CorruptionService AS;
    private final Logger log= LoggerFactory.getLogger(Corruption.class);
    @PostMapping("/new")
    public ResponseEntity<Corruption> addNewTeam(@Valid @RequestBody Corruption C1)
    {
        return AS.addActivite(C1);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Corruption>> getAllTeams()
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
    public ResponseEntity<?> updateactivite(@PathVariable Long id, @Valid @RequestBody Corruption A1)
    {
        return AS.updateactivite(id, A1);
    }
    @DeleteMapping("/Delete/{id}")
    public Map<String, Boolean> deleteactivite(@PathVariable Long id)
    {
        return AS.deleteActivite(id);
    }





}
