package GCS.GCS_Etudiant.entites;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EtudiantResponse {
    private Long id;
    private String nom;
    private Long division;
    private String specialite;
    private LocalDate anniversaire;
    private LocalDate jourDebutEcole;
    private String divisions;
}
