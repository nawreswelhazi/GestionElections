package ProjetElection.ProjetElection.Controllers;

import ProjetElection.ProjetElection.Entities.Corruption;
import ProjetElection.ProjetElection.Entities.Partisane;
import ProjetElection.ProjetElection.Services.PartisaneListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping("/Partisane")
public class PartisaneListController {

        @Autowired
        private PartisaneListService ls;
        private final Logger log= LoggerFactory.getLogger(Corruption.class);

        @PostMapping("/add")
        public ResponseEntity<Partisane> addNewPartisane(@Valid @RequestBody Partisane c)
        {return ls.addPartisane(c); }

        @GetMapping("/all")
        public ResponseEntity<List<Partisane>> getAllPartisanes()
        {
            return ls.getall();
        }

        @GetMapping("/get/{id}")
        public ResponseEntity<?> getPartisaneById(@PathVariable Long id)
        {return ls.getonePartisane(id); }

        @PutMapping("/add/{id}")
        public ResponseEntity<Partisane> update(@PathVariable Long id, @Valid @RequestBody Partisane A1)
        { return ls.updatePartisane(id,A1); }


        @DeleteMapping("/delete/{id}")
        public ResponseEntity<?> deleteInde(@PathVariable Long id)
        {
            return ls.deletePartisane(id);
        }

}
