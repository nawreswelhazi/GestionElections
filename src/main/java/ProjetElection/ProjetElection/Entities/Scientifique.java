package ProjetElection.ProjetElection.Entities;


import java.util.Date;
import javax.persistence.*;
import lombok.*;
@NoArgsConstructor
@RequiredArgsConstructor
@Data
@ToString
@Entity
@DiscriminatorValue("scientifique")
public class Scientifique extends Activite {

    @NonNull
    private String type;
    @NonNull
    private Long nbPublic;
    @NonNull
    private Long budget;
    @NonNull
    private Long tauxdorganisation;
    @NonNull
    private Date dateDebut;
    @NonNull
    private Date dateFin;

}
