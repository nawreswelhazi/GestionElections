package ProjetElection.ProjetElection.Entities;


import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@Entity
@DiscriminatorValue("politique")

public class Politique extends Activite {
    @NonNull
    private int visibiliteActivite;
    @NonNull
    private int visibiliteCandidat;
    @NonNull
    private float tauxOrganisation;
    @NonNull
    private float resultatAtteint;
    @NonNull
    private Date dateDebut;
    @NonNull
    private Date dateFin;
}

