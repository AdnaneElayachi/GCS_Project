package GCS.GCS_Etudiant.controllers;


import GCS.GCS_Etudiant.entites.Cours;
import GCS.GCS_Etudiant.entites.Division;
import GCS.GCS_Etudiant.entites.Etudiant;
import GCS.GCS_Etudiant.repository.EtudiantRepository;
import GCS.GCS_Etudiant.services.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Etudiants/")
public class EtudiantControllers {

    private final EtudiantRepository etudiantRepository;

    @Autowired
    public EtudiantControllers(EtudiantRepository etudiantRepository, EtudiantService etudiantService) {
        this.etudiantRepository = etudiantRepository;
    }

    @PostMapping("/Etu")
    public Etudiant createEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }


}
