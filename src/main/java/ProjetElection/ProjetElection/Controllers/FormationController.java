package ProjetElection.ProjetElection.Controllers;

import ProjetElection.ProjetElection.Entities.Electeur;
import ProjetElection.ProjetElection.Entities.Formation;
import ProjetElection.ProjetElection.Repositories.FormationRepository;
import ProjetElection.ProjetElection.Services.FormationServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200" , allowedHeaders="*")
@RequestMapping("/formations")
public class FormationController {
    @Autowired
    private FormationServices formationService;
    private final Logger log= LoggerFactory.getLogger(Formation.class);
    @GetMapping("/all")
    public ResponseEntity<List<Formation>> getFormations(){ return formationService.getall(); }
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getFormationById(@PathVariable Long id)
    {
        return formationService.getOneFormation(id);
    }
    @PostMapping("/add")
    public ResponseEntity<Formation> postFormation(@RequestBody Formation t){ return formationService.addFormation(t); }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteFormation (@PathVariable Long  id){ return formationService.deleteFormation(id);}
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateAvis(@PathVariable Long id , @Valid @RequestBody Formation a1){ return formationService.updateFormation(id,a1); }}
