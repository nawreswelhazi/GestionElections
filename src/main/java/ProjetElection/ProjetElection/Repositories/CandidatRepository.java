package ProjetElection.ProjetElection.Repositories;

import ProjetElection.ProjetElection.Entities.Candidat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidatRepository extends JpaRepository<Candidat, Long> {

    public Candidat findByUsername(String username);
}
