package GCS.GCS_GAdministation.repository;

import GCS.GCS_GAdministation.entity.Administration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministrationRepository extends JpaRepository<Administration, Long> {


}
