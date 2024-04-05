package ProjetElection.ProjetElection.Repositories;

import ProjetElection.ProjetElection.Entities.Corruption;
import ProjetElection.ProjetElection.Entities.Politique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PolitiqueRepository extends JpaRepository<Politique, Long> {
    @Query("FROM Politique WHERE nom = ?1")
    public Optional<Politique> findByName(String name);
}
