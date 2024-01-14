// Etudiant.java
package GCS.GCS_Etudiant.entites;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Etudiant")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Etudiant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private Long division;
    private String specialite;
    private LocalDate anniversaire;
    private LocalDate jourDebutEcole;

    @ManyToMany
    @JoinTable(
            name = "etudiant_division",
            joinColumns = @JoinColumn(name = "etudiant_id"),
            inverseJoinColumns = @JoinColumn(name = "division_id")
    )
    private List<Division> divisions;

    @ManyToMany
    @JoinTable(
            name = "etudiant_cours",
            joinColumns = @JoinColumn(name = "etudiant_id"),
            inverseJoinColumns = @JoinColumn(name = "cours_id")
    )
    private List<Cours> cours;
}
