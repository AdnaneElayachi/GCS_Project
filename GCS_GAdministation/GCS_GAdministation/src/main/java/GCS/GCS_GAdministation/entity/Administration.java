package GCS.GCS_GAdministation.entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Administration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToMany
    private List<Utilisateur> utilisateurs;






}