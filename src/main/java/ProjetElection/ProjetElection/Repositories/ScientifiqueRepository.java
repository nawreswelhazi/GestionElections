package ProjetElection.ProjetElection.Repositories;

import ProjetElection.ProjetElection.Entities.Politique;
import ProjetElection.ProjetElection.Entities.Scientifique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ScientifiqueRepository extends JpaRepository<Scientifique, Long> {
    @Query("FROM Scientifique WHERE nom = ?1")
    public Optional<Scientifique> findByName(String name);
}
