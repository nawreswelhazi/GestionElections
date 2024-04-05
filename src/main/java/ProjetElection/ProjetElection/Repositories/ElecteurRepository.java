package ProjetElection.ProjetElection.Repositories;

import ProjetElection.ProjetElection.Entities.Corruption;
import ProjetElection.ProjetElection.Entities.Electeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.transaction.Transactional;
import java.util.Optional;

@RepositoryRestResource
public interface ElecteurRepository extends JpaRepository<Electeur,Long>  {
    @Query("FROM Electeur WHERE username = ?1")
    public Optional<Electeur> findByUserName(String username);

    @Modifying
    @Transactional
    @Query("DELETE FROM Electeur WHERE username = ?1")
    public void deleteByUserName(String username);
}
