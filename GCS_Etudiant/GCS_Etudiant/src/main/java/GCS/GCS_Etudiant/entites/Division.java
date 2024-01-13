package GCS.GCS_Etudiant.entites;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nomDivision;


    @ManyToMany
    @JoinTable(
            name = "etudiant_division",
            joinColumns = @JoinColumn(name = "etudiant_id"),
            inverseJoinColumns = @JoinColumn(name = "division_id")
    )
    private List<Division> divisions = new ArrayList<>();
}

