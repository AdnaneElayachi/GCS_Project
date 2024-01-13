package GCS.GCS_GAdministation.entity;

import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfesseurResponse {
    private Long id;
    private String nom;
    private Date tempsEnseignement;

    private String specialite;

    private String cours;
}
