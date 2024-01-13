package GCS.GCS_GAdministation.services;

import GCS.GCS_GAdministation.entity.*;
import GCS.GCS_GAdministation.repository.CoursRepository;
import GCS.GCS_GAdministation.repository.ProfesseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CoursService {

    @Autowired
    private CoursRepository coursRepository;
    private ProfesseurRepository professeurRepository;


    @Autowired
    private RestTemplate restTemplate;

    private final String URL = "http://localhost:8888/SERVICE-Administration/GCS/cours";

    public List<CoursResponse> findAllCours() {
        List<Cours> coursList = coursRepository.findAll();

        ResponseEntity<Professeur[]> response = restTemplate.getForEntity(this.URL + "/Liste", Professeur[].class);
        Professeur[] professeurs = response.getBody();

        return coursList.stream()
                .map(cours -> mapToCoursResponse(cours, professeurs))
                .collect(Collectors.toList());
    }

    private CoursResponse mapToCoursResponse(Cours cours, Professeur[] professeurs) {

        return CoursResponse.builder()
                .id(cours.getId())
                .nomCours(cours.getNomCours())
                .professeur(String.valueOf(cours.getProfesseur()))
                .build();
    }


    public ResponseEntity<String> ajouterUtilisateur(@RequestBody CoursResponse coursResponser) {
        Cours cour = new Cours();
        Professeur professeur = professeurRepository.findByNom(coursResponser.getProfesseur());

        cour.setNomCours(coursResponser.getNomCours());
        cour.setProfesseur(professeur);

        Cours savedCour = coursRepository.save(cour);

        return ResponseEntity.ok("Cour ajouté avec l'ID : " + savedCour.getId());
    }


}
