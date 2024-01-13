package GCS.GCS_GAdministation.repository;

import GCS.GCS_GAdministation.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long> {
    @Query("SELECT u FROM Utilisateur u WHERE u.fonction = ?1")
    List<Utilisateur> findByFonction(String fonction);

}
