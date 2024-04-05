package ProjetElection.ProjetElection.Repositories;

import ProjetElection.ProjetElection.Entities.Coalition;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CoallitionListeRepository extends JpaRepository<Coalition,Long> {
}
