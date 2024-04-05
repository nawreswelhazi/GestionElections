package ProjetElection.ProjetElection.Controllers;

import ProjetElection.ProjetElection.Entities.Avis;
import ProjetElection.ProjetElection.Services.AvisServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/avis")
public class AvisController {

    @Autowired
    private AvisServices as;

    private final Logger log = LoggerFactory.getLogger(Avis.class);

    @GetMapping("/all")
    public ResponseEntity<List<Avis>> getAvis() {
        return as.getall();
    }


    @PostMapping("/add")
    public ResponseEntity<Avis> postAvis(@RequestBody Avis t) {
        return as.addAvis(t);
    }
/*
    @GetMapping("/get/{id}/{id2}")
    public ResponseEntity<?> getAvis(@PathVariable Long id,@PathVariable Long id2){ return as.getAvis(id,id2); }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Avis> postAvis(@PathVariable Long id){ return as.deleteAvis(id);}

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateAvis(@PathVariable Long id, @Valid @RequestBody Avis a1){ return as.updateAvisNote(id,a1); }
*/
}
