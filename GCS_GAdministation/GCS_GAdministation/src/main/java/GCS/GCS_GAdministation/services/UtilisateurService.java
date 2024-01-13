package GCS.GCS_GAdministation.services;

import GCS.GCS_GAdministation.entity.Administration;
import GCS.GCS_GAdministation.entity.Utilisateur;
import GCS.GCS_GAdministation.entity.UtilisateurResponse;
import GCS.GCS_GAdministation.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UtilisateurService {
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }
    private final String URL = "http://localhost:8888/SERVICE-Administration/GCS/utilisateurs";


    public List<UtilisateurResponse> findAllUtilisateur() {

        List<Utilisateur> utilisateurs = utilisateurRepository.findAll();


        ResponseEntity<Administration[]> response = restTemplate.getForEntity(this.URL + "utilisateurs", Administration[].class);
        Administration[] administrations = response.getBody();


        return utilisateurs.stream()
                .map(utilisateur -> mapToUtilisateurResponse(utilisateur, administrations))
                .collect(Collectors.toList());
    }

    private UtilisateurResponse mapToUtilisateurResponse(Utilisateur utilisateur, Administration[] administrations) {
        Administration foundAdministration = Arrays.stream(administrations)
                .filter(administration -> administration.getUtilisateurs().contains(utilisateur.getId()))
                .findFirst()
                .orElse(null);

        return UtilisateurResponse.builder()
                .id(utilisateur.getId())
                .nom(utilisateur.getNom())
                .fonction(utilisateur.getFonction())
                .email(utilisateur.getEmail())
                .motdepasse(utilisateur.getMotdepasse())
                .build();

    }


    public UtilisateurResponse findUtilisateurById(Long id) throws Exception {
        Utilisateur utilisateur = utilisateurRepository.findById(id).orElseThrow(() -> new Exception("Invalid Utilisateur Id"));
              return UtilisateurResponse.builder()
                .id(utilisateur.getId())
                .nom(utilisateur.getNom())
                .fonction(utilisateur.getFonction())
                .email(utilisateur.getEmail())
                .motdepasse(utilisateur.getMotdepasse())
                .build();
    }
    public UtilisateurResponse findByFonction(String fonction) throws Exception {
        Utilisateur utilisateur = (Utilisateur) utilisateurRepository.findByFonction(fonction);

        if (utilisateur == null) {
            throw new Exception("Utilisateur not found for fonction: " + fonction);
        }

        return UtilisateurResponse.builder()
                .id(utilisateur.getId())
                .nom(utilisateur.getNom())
                .fonction(utilisateur.getFonction())
                .email(utilisateur.getEmail())
                .motdepasse(utilisateur.getMotdepasse())
                .build();
    }

    public ResponseEntity<String> ajouterUtilisateur(@RequestBody UtilisateurResponse utilisateurRequest) {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setNom(utilisateurRequest.getNom());
        utilisateur.setFonction(utilisateurRequest.getFonction());
        utilisateur.setEmail(utilisateurRequest.getEmail());
        utilisateur.setMotdepasse(utilisateurRequest.getMotdepasse());

        Utilisateur savedUtilisateur = utilisateurRepository.save(utilisateur);

        return ResponseEntity.ok("Utilisateur ajouté avec l'ID : " + savedUtilisateur.getId());
    }





}
