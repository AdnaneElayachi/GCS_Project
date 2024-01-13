package GCS.GCS_Payement.entites;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

public class Etudiant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private Long division;
    private String specialite;
    private LocalDate anniversaire;
    private LocalDate jourDebutEcole;
@OneToMany
    private List<Paiement> divisions;
}
