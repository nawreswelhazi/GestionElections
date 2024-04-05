package ProjetElection.ProjetElection.Entities;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@NoArgsConstructor
@Data
@Entity
@DiscriminatorValue("Partisane")
public class Partisane extends ListeElectorale {

}