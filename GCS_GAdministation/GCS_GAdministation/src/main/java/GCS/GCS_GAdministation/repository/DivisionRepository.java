package GCS.GCS_GAdministation.repository;

import GCS.GCS_GAdministation.entity.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DivisionRepository extends JpaRepository<Division, Long> {

    @Query("SELECT d FROM Division d WHERE d.nom = :nom")
    Optional<Division> findDivisionbyName(String nom);
}
