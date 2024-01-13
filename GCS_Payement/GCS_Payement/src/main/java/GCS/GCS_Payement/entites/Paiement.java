package GCS.GCS_Payement.entites;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "Paiement")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Paiement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "type")
    private String type;

    @Column(name = "montant")
    private Double montant;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_ajout")
    private Date dateAjout;
    @ManyToOne
    @JoinColumn(name = "etudiant_id")
    private Etudiant etudiant;
}
