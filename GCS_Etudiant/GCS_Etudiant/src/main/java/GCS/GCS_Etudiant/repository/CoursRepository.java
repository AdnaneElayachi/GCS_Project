package GCS.GCS_Etudiant.repository;


import GCS.GCS_Etudiant.entites.Cours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursRepository extends JpaRepository<Cours, Long> {
}
