package GCS.GCS_Etudiant.entites;

import jakarta.persistence.*;
import lombok.*;


@Table(name = "Cours")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Cours {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nomCours;

    @ManyToOne
    @JoinColumn(name = "professeur_id")
    private Professeur professeur;
}
