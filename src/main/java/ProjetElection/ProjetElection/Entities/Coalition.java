package ProjetElection.ProjetElection.Entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@NoArgsConstructor
@Data
@Entity
@DiscriminatorValue("Coalition")
public class Coalition extends ListeElectorale {
    private int nbpartie;

}