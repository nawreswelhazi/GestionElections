package ProjetElection.ProjetElection.Entities;

import sun.rmi.runtime.Log;

import javax.persistence.*;

@Entity
public class Justificatif {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private Byte Support;

    @ManyToOne
    private Activite act;


}
