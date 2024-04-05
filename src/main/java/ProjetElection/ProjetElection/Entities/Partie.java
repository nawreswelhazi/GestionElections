package ProjetElection.ProjetElection.Entities;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
@Entity
@Getter
@Setter
public class Partie  {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String nom ;
    private Date date_creation;
    private String local ;

    @OneToMany(mappedBy="partieCandidat")
    private Set<Candidat> ListCandidat = new HashSet<Candidat>();
}
