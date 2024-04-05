package ProjetElection.ProjetElection.Entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
public class Candidat {
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
    @NonNull
    private Byte photo;
    private String facebook;
    private String instagram;
    private String linkedin;
    private String twitter;

    public Candidat(Long id) {
        this.id = id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setDate_naiss(Date date_naiss) {
        this.date_naiss = date_naiss;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoto(Byte photo) {
        this.photo = photo;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Date getDate_naiss() {
        return date_naiss;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Byte getPhoto() {
        return photo;
    }

    public String getFacebook() {
        return facebook;
    }

    public String getInstagram() {
        return instagram;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public String getTwitter() {
        return twitter;
    }

    @OneToMany(mappedBy = "can", cascade = CascadeType.ALL)
    private Set<Avis> avisCandidatSet = new HashSet<Avis>();
    @OneToMany(mappedBy="cand")
    private Set<Formation> formationSet = new HashSet<Formation>();
    @ManyToOne
    private Partie partieCandidat;
    //@ManyToOne //pour la relation admin gère candidats
    //private Administrateur adminGerant;

    @OneToMany(mappedBy="activCandidat")
    private Set<Activite> ListActivite= new HashSet<Activite>();

    @ManyToOne
    private ListeElectorale listemembre;
    @NonNull
    @OneToOne(mappedBy = "teteDeliste")
    private ListeElectorale listeElectoraleTete;
    public int calcul_score(){
        return 20;
    }
}
