package ProjetElection.ProjetElection.Controllers;



import ProjetElection.ProjetElection.Entities.Politique;
import ProjetElection.ProjetElection.Services.PolitiqueService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ActivitesPolitique")
public class PolitiqueController {
    @Autowired
    private PolitiqueService PS;
    private final Logger log= LoggerFactory.getLogger(Politique.class);

    @PostMapping("/new")
    public ResponseEntity<Politique> addNewTeam(@Valid @RequestBody Politique P1)
    {
        return PS.addActivite(P1);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Politique>> getAllTeams()
    {
        return PS.getAllActivites();
    }

    @GetMapping("/Activite/{id}")
    public ResponseEntity<?> getActiviteById(@PathVariable Long id)
    {
        return PS.getOneActivite(id);
    }
    /*@DeleteMapping("/Activitedelete/{id}")
    public void deleteActivite( @PathVariable Long id)
    {
        AS.deleteActivite(id);
    }*/
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateactivite(@PathVariable Long id, @Valid @RequestBody Politique P1)
    {
        return PS.updateactivite(id, P1);
    }
    @DeleteMapping("/Delete/{id}")
    public Map<String, Boolean> deleteactivite(@PathVariable Long id)
    {
        return PS.deleteActivite(id);
    }





}