package ProjetElection.ProjetElection.Controllers;

import ProjetElection.ProjetElection.Entities.Coalition;
import ProjetElection.ProjetElection.Entities.Corruption;
import ProjetElection.ProjetElection.Services.CoallitionListeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Coallition")
public class CoallitionListeController {

    @Autowired
    private CoallitionListeService ls;
    private final Logger log= LoggerFactory.getLogger(Corruption.class);

    @PostMapping("/add")
    public ResponseEntity<Coalition> addNewTeam(@Valid @RequestBody Coalition c)
    {return ls.addCoalition(c); }

    @GetMapping("/all")
    public ResponseEntity<List<Coalition>> getAllTeams()
    {
        return ls.getall();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getActiviteById(@PathVariable Long id)
    {return ls.getoneCoalition(id); }

    @PutMapping("/add/{id}")
    public ResponseEntity<Coalition> update(@PathVariable Long id, @Valid @RequestBody Coalition A1)
    { return ls.updateCoalition(id,A1); }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletecoa(@PathVariable Long id)
    {
        return ls.deleteCoalition(id);
    }



}
