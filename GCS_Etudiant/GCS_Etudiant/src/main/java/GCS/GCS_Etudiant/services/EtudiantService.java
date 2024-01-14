package GCS.GCS_Etudiant.services;

import GCS.GCS_Etudiant.entites.Division;
import GCS.GCS_Etudiant.entites.Etudiant;
import GCS.GCS_Etudiant.entites.EtudiantResponse;
import GCS.GCS_Etudiant.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EtudiantService {

    @Autowired
    private EtudiantRepository etudiantRepository;

    @Autowired
    private RestTemplate restTemplate;

    private final String URLGroups = "http://localhost:8888/SERVICE-Etudiant";

    public List<EtudiantResponse> findAll() {
        List<Etudiant> etudiants = etudiantRepository.findAll();
        ResponseEntity<Division[]> response = restTemplate.getForEntity(this.URLGroups + "/api/Division/", Division[].class);
        Division[] divisions = response.getBody();

        return etudiants.stream()
                .map(e -> mapToEtudiantResponse(e, divisions))
                .collect(Collectors.toList());
    }

    public EtudiantResponse findEtudiantByID(Long id) throws Exception {
        Etudiant etudiant = etudiantRepository.findById(id)
                .orElseThrow(() -> new Exception("Étudiant non valide"));

        Optional<Division> optionalDivision = getDivisionById(etudiant.getDivision());

        return EtudiantResponse.builder()
                .id(etudiant.getId())
                .nom(etudiant.getNom())
                .specialite(etudiant.getSpecialite())
                .anniversaire(etudiant.getAnniversaire())
                .jourDebutEcole(etudiant.getJourDebutEcole())
                .division(etudiant.getDivision())
                .build();
    }

    private EtudiantResponse mapToEtudiantResponse(Etudiant etudiant, Division[] divisions) {
        Optional<Division> optionalDivision = getDivisionById(etudiant.getDivision());

        return EtudiantResponse.builder()
                .id(etudiant.getId())
                .nom(etudiant.getNom())
                .specialite(etudiant.getSpecialite())
                .anniversaire(etudiant.getAnniversaire())
                .jourDebutEcole(etudiant.getJourDebutEcole())
                .division(etudiant.getDivision())
                .build();
    }

    private Optional<Division> getDivisionById(Long id) {
        Division[] divisions = restTemplate.getForObject(this.URLGroups + "/api/Division/", Division[].class);

        return Arrays.stream(divisions)
                .filter(division -> Objects.equals(division.getId(), id))
                .findFirst();
    }
    public List<Etudiant> getEtudiantesByDivision(String division) {
        return etudiantRepository.getEtudiantesByDivision(division);
    }

    public List<Etudiant> getEtudiantsByCoursNom(String nomCours) {
        return etudiantRepository.findByCoursNom(nomCours);
    }



}
