package ProjetElection.ProjetElection.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ProjetElection.ProjetElection.Entities.Partie;

public interface PartieRepository extends JpaRepository<Partie, Long> {

}
