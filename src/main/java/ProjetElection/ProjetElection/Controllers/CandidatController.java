package ProjetElection.ProjetElection.Controllers;


import ProjetElection.ProjetElection.Entities.Candidat;
import ProjetElection.ProjetElection.Repositories.CandidatRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;
import java.util.Optional;
@RestController
@CrossOrigin(origins = "http://localhost:4200" , allowedHeaders="*")
@RequestMapping("/candidat")
public class CandidatController {
        @Autowired
        private CandidatRepository candidatRepository;
        private final Logger log = LoggerFactory.getLogger(Candidat.class);
        @GetMapping(value="/listcandidat")
        public ResponseEntity<?> listcandidat(){
            Collection<Candidat> candidats =candidatRepository.findAll();
            if (candidats.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(candidats, HttpStatus.OK);
        }
        @GetMapping("/getcandidat/{id}")
        public Optional<Candidat> getcandidatById(@PathVariable Long id) {
            return candidatRepository.findById(id);
        }
        @PostMapping("/newcandidat")
        public Candidat addcandidat(@RequestBody Candidat candidat) {
            return candidatRepository.save(candidat);
        }
        @DeleteMapping(value="/listcandidat/{id}")
        public void delete(@PathVariable(name="id") Long id ){

            candidatRepository.deleteById(id);
        }
        @PutMapping(value="/updatecandidat/{id}")
        public Candidat update(@PathVariable(name="id") Long id ,@RequestBody Candidat p){

            p.setId(id);
            return candidatRepository.save(p);
        }
        @GetMapping("/getcandidatbyusername/{username}")
        public Candidat getcandidatByusername(@PathVariable String username) {
            return candidatRepository.findByUsername(username);
        }

    }


