package GCS.GCS_Etudiant.controllers;


import GCS.GCS_Etudiant.entites.Cours;
import GCS.GCS_Etudiant.entites.Division;
import GCS.GCS_Etudiant.entites.Etudiant;
import GCS.GCS_Etudiant.entites.EtudiantResponse;
import GCS.GCS_Etudiant.repository.EtudiantRepository;
import GCS.GCS_Etudiant.services.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Etudiants/")
public class EtudiantControllers {

    private  EtudiantRepository etudiantRepository;
    private EtudiantService  etudiantService;

    @Autowired
    public EtudiantControllers(EtudiantRepository etudiantRepository, EtudiantService etudiantService) {
        this.etudiantRepository = etudiantRepository;
    }

    @PostMapping("/Nouvel")
    public Etudiant createEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }
    @GetMapping
    public List<EtudiantResponse> GetAllEtudiants(){
        return etudiantService.findAll();
    }


    @GetMapping("/{id}")
    public List<EtudiantResponse> findEtudiantByID(Long id) throws Exception {
        return (List<EtudiantResponse>) etudiantService.findEtudiantByID(id);
    }

    @GetMapping("/{division}")
    public List<Etudiant> getEtudiantesByDivision(@PathVariable String division) {
        return etudiantService.getEtudiantesByDivision(division);
    }
    @GetMapping("/cour")
    public List<Etudiant> getEtudiantsByCours(@RequestParam String nomCours) {
        return etudiantService.getEtudiantsByCoursNom(nomCours);
    }

}
