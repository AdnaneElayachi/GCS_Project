package GCS.GCS_Etudiant.entites;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Professeur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nom;

    private LocalDate tempsEnseignement;

    private String specialite;

    @OneToMany(mappedBy = "professeur")
    private List<Cours> cours;
}
