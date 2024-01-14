package GCS.GCS_Etudiant.entites;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity

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
    @ManyToMany
    @JoinTable(
            name = "cours_etudiant",
            joinColumns = @JoinColumn(name = "cours_id"),
            inverseJoinColumns = @JoinColumn(name = "etudiant_id")
    )
    private List<Etudiant> etudiants;
}
