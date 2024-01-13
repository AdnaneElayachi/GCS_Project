package GCS.GCS_GAdministation.repository;
import GCS.GCS_GAdministation.entity.Cours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursRepository extends JpaRepository<Cours, Long> {

}
