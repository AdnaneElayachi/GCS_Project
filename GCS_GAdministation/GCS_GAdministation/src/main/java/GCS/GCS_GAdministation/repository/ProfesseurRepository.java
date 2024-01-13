package GCS.GCS_GAdministation.repository;

import GCS.GCS_GAdministation.entity.Division;
import GCS.GCS_GAdministation.entity.Professeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfesseurRepository  extends JpaRepository<Professeur,Long> {
    Professeur findByNom(String nom);

}
