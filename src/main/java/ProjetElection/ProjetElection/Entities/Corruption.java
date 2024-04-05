package ProjetElection.ProjetElection.Entities;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@DiscriminatorValue("corruption")
public class Corruption extends Activite{
    @NonNull
    private long tauxDepreciation;
}
