package ProjetElection.ProjetElection.Entities;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Administrateur {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String nom;
    @NonNull
    private String prenom;
    @NonNull
    private Date date_naiss;
    @NonNull
    private String username;
    @NonNull
    private String password;

    //@OneToMany(mappedBy="adminGerant") //pour la relation admin gère candidats
    //private Set<Candidat> Candidatsgere = new HashSet<Candidat>();

}
