package GCS.GCS_GAdministation.controlles;

import GCS.GCS_GAdministation.entity.*;
import GCS.GCS_GAdministation.services.CoursService;
import GCS.GCS_GAdministation.services.ProfesseurService;
import GCS.GCS_GAdministation.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/GCS/administration")
public class AdministrationController {

    private UtilisateurService utilisateurService;
    private ProfesseurService professeurService;
    private CoursService coursService;

    @Autowired
    public AdministrationController(UtilisateurService utilisateurService, ProfesseurService professeurService, CoursService coursService) {
        this.utilisateurService = utilisateurService;
        this.professeurService = professeurService;
        this.coursService = coursService;
    }

    @GetMapping("/utilisateurs")
    public List<UtilisateurResponse> findAllUtilisateur() {
        return utilisateurService.findAllUtilisateur();
    }

    @GetMapping("/professeurs")
    public List<ProfesseurResponse> findAllProfesseurs() {
        return professeurService.findAllProfesseurs();
    }

    @GetMapping("/utilisateur/{id}")
    public Optional<UtilisateurResponse> findUtilisateurById(@PathVariable Long id) throws Exception {
        return Optional.ofNullable(utilisateurService.findUtilisateurById(id));
    }

    @GetMapping("/utilisateurs/byFonction/{fonction}")
    public Optional<UtilisateurResponse> findUtilisateurByFonction(@PathVariable String fonction) throws Exception {
        return Optional.ofNullable((UtilisateurResponse) utilisateurService.findByFonction(fonction));
    }
}
