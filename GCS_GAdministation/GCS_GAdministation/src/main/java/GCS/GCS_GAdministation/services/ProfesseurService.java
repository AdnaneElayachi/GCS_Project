package GCS.GCS_GAdministation.services;

import GCS.GCS_GAdministation.entity.Cours;
import GCS.GCS_GAdministation.entity.CoursResponse;
import GCS.GCS_GAdministation.entity.Professeur;
import GCS.GCS_GAdministation.entity.ProfesseurResponse;
import GCS.GCS_GAdministation.repository.CoursRepository;
import GCS.GCS_GAdministation.repository.ProfesseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfesseurService {

    @Autowired
    private ProfesseurRepository professeurRepository;

    @Autowired
    private CoursRepository coursRepository;

    public List<ProfesseurResponse> findAllProfesseurs() {
        List<Professeur> professeurs = professeurRepository.findAll();

        return professeurs.stream()
                .map(this::mapToProfesseurResponse)
                .collect(Collectors.toList());
    }

    private ProfesseurResponse mapToProfesseurResponse(Professeur professeur) {
        return ProfesseurResponse.builder()
                .id(professeur.getId())
                .nom(professeur.getNom())
                .tempsEnseignement(professeur.getTempsEnseignement())
                .specialite(professeur.getSpecialite())
                .build();
    }

    public ResponseEntity<String> ajouterProfesseur(ProfesseurResponse professeurResponse) {
        Professeur professeur = new Professeur();
        professeur.setNom(professeurResponse.getNom());
        professeur.setTempsEnseignement(professeurResponse.getTempsEnseignement());
        professeur.setSpecialite(professeurResponse.getSpecialite());

        Professeur savedProfesseur = professeurRepository.save(professeur);

        return ResponseEntity.ok("Professeur ajouté avec l'ID : " + savedProfesseur.getId());
    }
}
