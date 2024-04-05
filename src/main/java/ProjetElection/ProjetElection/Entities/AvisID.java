package ProjetElection.ProjetElection.Entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode // elle compare tt les attributs obligatoire
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class AvisID implements Serializable {
    @Column(name ="Candidat_id")
    private Long idCandidat;
    @Column(name ="Electeur_id")
    private Long idElecteur;


}
