package GCS.GCS_GAdministation.entity;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DivisionResponse {
    private long id;
    private String nom;
   private String description;

    private String cours;
}
