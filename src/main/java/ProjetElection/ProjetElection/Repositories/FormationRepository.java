package ProjetElection.ProjetElection.Repositories;

import ProjetElection.ProjetElection.Entities.Formation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.http.ResponseEntity;
import javax.transaction.Transactional;
import java.util.Optional;
@RepositoryRestResource
public interface FormationRepository extends JpaRepository<Formation,Long> {
    @Query("FROM Formation WHERE nom=?1")
    public Optional<Formation> findByForamtionName(String nom);}
