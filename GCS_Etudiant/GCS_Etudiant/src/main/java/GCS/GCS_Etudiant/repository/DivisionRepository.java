package GCS.GCS_Etudiant.repository;


import GCS.GCS_Etudiant.entites.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DivisionRepository extends JpaRepository<Division, Long> {
}
