package GCS.GCS_GAdministation.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Cours {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomCours;
    @ManyToOne
    private Professeur professeur;


}
