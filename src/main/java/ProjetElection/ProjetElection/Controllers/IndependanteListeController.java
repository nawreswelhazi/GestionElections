package ProjetElection.ProjetElection.Controllers;

import ProjetElection.ProjetElection.Entities.Independante;
import ProjetElection.ProjetElection.Entities.Corruption;
import ProjetElection.ProjetElection.Entities.Independante;
import ProjetElection.ProjetElection.Services.CoallitionListeService;
import ProjetElection.ProjetElection.Services.IndependanteListeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/Independante")
public class IndependanteListeController {
    @Autowired
    private IndependanteListeService ls;
    private final Logger log= LoggerFactory.getLogger(Corruption.class);

    @PostMapping("/add")
    public ResponseEntity<Independante> addNewIndependante(@Valid @RequestBody Independante c)
    {return ls.addIndependante(c); }

    @GetMapping("/all")
    public ResponseEntity<List<Independante>> getAllIndependantes()
    {
        return ls.getall();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getIndependanteById(@PathVariable Long id)
    {return ls.getoneIndependante(id); }

    @PutMapping("/add/{id}")
    public ResponseEntity<Independante> update(@PathVariable Long id, @Valid @RequestBody Independante A1)
    { return ls.updateIndependante(id,A1); }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteInde(@PathVariable Long id)
    {
        return ls.deleteIndependante(id);
    }


}
