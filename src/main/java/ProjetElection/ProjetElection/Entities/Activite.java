package ProjetElection.ProjetElection.Entities;
import javax.persistence.*;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@ToString(exclude="id")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="typeactivite", discriminatorType = DiscriminatorType.STRING)
public  abstract class Activite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    @EqualsAndHashCode.Include
    private String nom;
    @NonNull
    private byte support;

    @ManyToOne
    private Candidat activCandidat;

    @OneToMany(mappedBy = "act")
    private Set<Justificatif> just = new HashSet<Justificatif>();
    //public abstract float CalculScore();
}