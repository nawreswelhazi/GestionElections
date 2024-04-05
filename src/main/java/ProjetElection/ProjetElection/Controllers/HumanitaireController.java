package ProjetElection.ProjetElection.Controllers;


import ProjetElection.ProjetElection.Entities.Humanitaire;
import ProjetElection.ProjetElection.Services.HumanitaireService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ActivitesHumanitaire")
public class HumanitaireController {
    @Autowired
    private HumanitaireService HS;
    private final Logger log= LoggerFactory.getLogger(Humanitaire.class);

    @PostMapping("/new")
    public ResponseEntity<Humanitaire> addNewTeam(@Valid @RequestBody Humanitaire H1)
    {
        return HS.addActivite(H1);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Humanitaire>> getAllTeams()
    {
        return HS.getAllActivites();
    }

    @GetMapping("/Activite/{id}")
    public ResponseEntity<?> getActiviteById(@PathVariable Long id)
    {
        return HS.getOneActivite(id);
    }
    /*@DeleteMapping("/Activitedelete/{id}")
    public void deleteActivite( @PathVariable Long id)
    {
        AS.deleteActivite(id);
    }*/

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateactivite(@PathVariable Long id, @Valid @RequestBody Humanitaire H1)
    {
        return HS.updateactivite(id, H1);
    }



    @DeleteMapping("/Delete/{id}")
    public Map<String, Boolean> deleteactivite(@PathVariable Long id)
    {
        return HS.deleteActivite(id);
    }





}