package ProjetElection.ProjetElection.Repositories;

import ProjetElection.ProjetElection.Entities.Administratif;
import ProjetElection.ProjetElection.Entities.Humanitaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface HumanitaireRepository extends JpaRepository<Humanitaire, Long> {
    @Query("FROM Humanitaire WHERE nom = ?1")
    public Optional<Humanitaire> findByName(String name);
}
