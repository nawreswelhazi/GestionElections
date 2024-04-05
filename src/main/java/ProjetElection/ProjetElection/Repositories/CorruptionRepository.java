package ProjetElection.ProjetElection.Repositories;

import ProjetElection.ProjetElection.Entities.Administratif;
import ProjetElection.ProjetElection.Entities.Corruption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CorruptionRepository extends JpaRepository<Corruption, Long> {
    @Query("FROM Corruption WHERE nom = ?1")
    public Optional<Corruption> findByName(String name);
}
