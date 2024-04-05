package ProjetElection.ProjetElection.Entities;
import lombok.*;

import javax.persistence.*;
@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @Entity
@ToString(exclude = "id")
public class Formation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @NonNull
    private String nom ;
    @NonNull
    private Long duree;
    @NonNull
    private String domaine;
    @ManyToOne
    private Candidat cand;
    public void setId(Long id) {
        this.id = id;
    }
    public void setNom(String nom) {
        this.nom = nom; }
    public void setDuree(Long duree) {
        this.duree = duree;
    }
    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }

    public void setCand(Candidat cand) {
        this.cand = cand;
    }

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public Long getDuree() {
        return duree;
    }

    public String getDomaine() {
        return domaine;
    }

    public Candidat getCand() {
        return cand;
    }
}
