package ProjetElection.ProjetElection.Services;

import ProjetElection.ProjetElection.Entities.Administratif;
import ProjetElection.ProjetElection.Entities.Electeur;
import ProjetElection.ProjetElection.Entities.Formation;
import ProjetElection.ProjetElection.Repositories.FormationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FormationServices {
    @Autowired
    private FormationRepository fr;
    public ResponseEntity<Formation> addFormation(Formation t) {
        if (fr.findByForamtionName(t.getNom()).isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Formation T2 = fr.save(t);
        return new ResponseEntity<>(T2, HttpStatus.CREATED); }

    public ResponseEntity<List<Formation>> getall() {
        List<Formation> lst1 = fr.findAll();
        if (lst1.isEmpty())
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        return new ResponseEntity(lst1, HttpStatus.OK); }




    public ResponseEntity<?> getOneFormation(Long id) {
        Optional<Formation> formation1 = fr.findById(id);
        return formation1.map(x->ResponseEntity.ok().body(formation1))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND)); }


    public ResponseEntity deleteFormation(Long id) {
        Optional <Formation> t = fr.findById(id);
        if (!(t.isPresent()))
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        fr.deleteById(id);
        return new ResponseEntity(t,HttpStatus.OK);}

    public ResponseEntity<Electeur> updateFormation(Long id, Formation formnew) {
        Optional<Formation> t = fr.findById(id);
        if (!t.isPresent())
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        Formation t2 = t.get();
        t2.setDuree(formnew.getDuree());
        Formation t3 = fr.save(t2);
        return new ResponseEntity(t3, HttpStatus.OK);
    }

}
