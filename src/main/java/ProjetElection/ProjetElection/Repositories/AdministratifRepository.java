package ProjetElection.ProjetElection.Repositories;

import ProjetElection.ProjetElection.Entities.Administratif;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AdministratifRepository extends JpaRepository<Administratif, Long> {
    @Query("FROM Administratif WHERE nom = ?1")
    public Optional<Administratif> findByName(String name);
}
