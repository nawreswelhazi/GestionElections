package ProjetElection.ProjetElection.Entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@ToString(exclude = "id")
public class Electeur {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String nom;
    @NonNull
    private String prenom;
    @NonNull
    private String username;
    @NonNull
    private String password;
    @NonNull
    private int age;
    @NonNull
    private String niveau_etude;

    @OneToMany(mappedBy = "ele")
    private Set<Avis> AvisElecteurSet = new HashSet<Avis>();
}
