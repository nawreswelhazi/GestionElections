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
@DiscriminatorColumn(name="typeListe", discriminatorType = DiscriminatorType.STRING)
public abstract class ListeElectorale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    @EqualsAndHashCode.Include
    private String nom;
    @NonNull
    private String gouvernorat;
    @NonNull
    private String commune;

    @OneToOne
    private Candidat teteDeliste;

    @OneToMany(mappedBy="listemembre")
    private Set<Candidat> listCandidat= new HashSet<Candidat>();

    public ListeElectorale(Long id, @NonNull String nom, @NonNull String gouvernorat, @NonNull String commune, Candidat teteDeliste, Set<Candidat> listCandidat) {
        this.id = id;
        this.nom = nom;
        this.gouvernorat = gouvernorat;
        this.commune = commune;
        this.teteDeliste = teteDeliste;
        this.listCandidat = listCandidat;
    }
//public abstract float CalculScore();
}