package ProjetElection.ProjetElection.Entities;


import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@DiscriminatorValue("human")
public class Humanitaire extends Activite {
    @NonNull
    private String causeHumanitaire;
    @NonNull
    private boolean provocation;
    @NonNull

    private int nbParticipants;
    @NonNull

    private double fond;
    @NonNull

    private Date dateDebut;
    @NonNull

    private Date dateFin;


}

