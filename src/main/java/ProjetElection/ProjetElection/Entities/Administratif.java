package ProjetElection.ProjetElection.Entities;


import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@DiscriminatorValue("admin")
public class Administratif extends Activite{
    @NonNull
    private String poste;
    @NonNull
    private int anneesExperience;


}