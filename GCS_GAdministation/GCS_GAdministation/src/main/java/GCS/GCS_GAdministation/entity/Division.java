package GCS.GCS_GAdministation.entity;

import jakarta.persistence.*;
import lombok.*;



@Entity

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    private String nom;


    private String description;

    @ManyToOne
    @JoinColumn(name = "cour_id")
    private Cours cours;

}
