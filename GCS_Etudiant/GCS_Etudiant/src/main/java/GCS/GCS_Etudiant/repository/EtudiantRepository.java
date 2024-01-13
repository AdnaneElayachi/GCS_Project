package GCS.GCS_Etudiant.repository;


import GCS.GCS_Etudiant.entites.Cours;
import GCS.GCS_Etudiant.entites.Division;
import GCS.GCS_Etudiant.entites.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {


}
