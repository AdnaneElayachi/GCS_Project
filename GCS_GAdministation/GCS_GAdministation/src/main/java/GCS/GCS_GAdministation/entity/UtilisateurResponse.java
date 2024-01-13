package GCS.GCS_GAdministation.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UtilisateurResponse {
    private Long id;
    private String nom;
    private String fonction;
    private String email;
    private String motdepasse;
}
