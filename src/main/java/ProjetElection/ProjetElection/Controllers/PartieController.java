package ProjetElection.ProjetElection.Controllers;

import java.util.Collection;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ProjetElection.ProjetElection.Entities.Partie;
import ProjetElection.ProjetElection.Repositories.PartieRepository;
@RestController
@CrossOrigin(origins = "http://localhost:4200" , allowedHeaders="*")
@RequestMapping("/partie")
public class PartieController {
    @Autowired
    private PartieRepository partieRepository;
    private final Logger log =LoggerFactory.getLogger(Partie.class);

    @GetMapping(value="/listPartie")
    public ResponseEntity<?> listPartie(){
        Collection<Partie> parties =partieRepository.findAll();
        if (parties.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(parties,HttpStatus.OK);
    }
    @GetMapping("/getpartie/{id}")
    public Optional<Partie> getpartieById(@PathVariable Long id) {
        return partieRepository.findById(id);
    }
    @PostMapping("/newpartie")
    public Partie addpartie(@RequestBody Partie partie) {
        return partieRepository.save(partie);
    }
    @DeleteMapping(value="/listPartie/{id}")
    public void delete(@PathVariable(name="id") Long id ){

        partieRepository.deleteById(id);
    }
    @PutMapping(value="/updatepartie/{id}")
    public Partie update(@PathVariable(name="id") Long id ,@RequestBody Partie p){
        p.setId(id);

        return partieRepository.save(p);

    }


}
