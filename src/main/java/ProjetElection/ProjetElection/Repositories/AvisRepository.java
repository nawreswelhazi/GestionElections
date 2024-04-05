package ProjetElection.ProjetElection.Repositories;

import ProjetElection.ProjetElection.Entities.Administratif;
import ProjetElection.ProjetElection.Entities.Avis;
import ProjetElection.ProjetElection.Entities.Corruption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AvisRepository extends JpaRepository<Avis, Long> {
    /*@Query("FROM avis WHERE ele_id=?1 AND can_id=?2")
    public Optional<Avis> findById2(Long id, Long id2);*/



}