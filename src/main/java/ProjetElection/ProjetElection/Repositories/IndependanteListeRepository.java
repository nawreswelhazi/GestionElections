package ProjetElection.ProjetElection.Repositories;

import ProjetElection.ProjetElection.Entities.Independante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IndependanteListeRepository extends JpaRepository<Independante,Long> {
}
