package ProjetElection.ProjetElection.Entities;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@ToString(exclude = "id")
public class Avis {
    @EmbeddedId
    private AvisID id ;
    private String Commentaire;
    private int note;

    @ManyToOne
    @MapsId("idElecteur")
    private Electeur ele;

    @ManyToOne
    @MapsId("idCandidat")
    private Candidat can;
}
