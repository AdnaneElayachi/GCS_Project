package GCS.GCS_GAdministation.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdministrationResponse {
private Long id;
private String utilisateures;

}
