package ProjetElection.ProjetElection.Controllers;




import ProjetElection.ProjetElection.Entities.Scientifique;
import ProjetElection.ProjetElection.Services.ScientifiqueService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ActivitesScientifique")
public class ScientifiqueController {
    @Autowired
    private ScientifiqueService SS;
    private final Logger log= LoggerFactory.getLogger(Scientifique.class);
    @PostMapping("/new")
    public ResponseEntity<Scientifique> addNewTeam(@Valid @RequestBody Scientifique S1)
    {
        return SS.addActivite(S1);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Scientifique>> getAllTeams()
    {
        return SS.getAllActivites();
    }
    @GetMapping("/Activite/{id}")
    public ResponseEntity<?> getActiviteById(@PathVariable Long id)
    {
        return SS.getOneActivite(id);
    }
    /*@DeleteMapping("/Activitedelete/{id}")
    public void deleteActivite( @PathVariable Long id)
    {
        AS.deleteActivite(id);
    }*/

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateactivite(@PathVariable Long id, @Valid @RequestBody Scientifique P1)
    {
        return SS.updateactivite(id, P1);
    }



    @DeleteMapping("/Delete/{id}")
    public Map<String, Boolean> deleteactivite(@PathVariable Long id)
    {
        return SS.deleteActivite(id);
    }





}