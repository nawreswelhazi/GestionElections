package ProjetElection.ProjetElection.Controllers;


import ProjetElection.ProjetElection.Entities.Avis;
import ProjetElection.ProjetElection.Entities.Electeur;
import ProjetElection.ProjetElection.Entities.Formation;
import ProjetElection.ProjetElection.Repositories.ElecteurRepository;
import ProjetElection.ProjetElection.Services.ElecteurServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/electeurs")
public class ElecteurController {

    @Autowired
    private ElecteurServices elecrepos;

    private final Logger log= LoggerFactory.getLogger(Electeur.class);

    @GetMapping("/all")
    public ResponseEntity<List<Electeur>> getElecteurs(){
        return elecrepos.getall();
    }

    @GetMapping("/get/{username}")
    public ResponseEntity<?> getElecteur(@PathVariable String username){ return elecrepos.getoneelecteur(username); }

    @PostMapping("/add")
    public ResponseEntity postElecteur(@RequestBody Electeur t){
        return elecrepos.addElecteur(t);
    }

    @DeleteMapping("/delete/{username}")
    public ResponseEntity deleteElecteur (@PathVariable String username){ return elecrepos.deleteElecteur(username);}

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateAvis(@PathVariable Long id, @Valid @RequestBody Electeur a1){ return elecrepos.updateElecteur(id,a1); }
}

