package ProjetElection.ProjetElection.Repositories;

import ProjetElection.ProjetElection.Entities.Partisane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

public interface PartisaneListeRepository extends JpaRepository<Partisane,Long> {
}
