package GCS.GCS_GAdministation.services;

import GCS.GCS_GAdministation.entity.Administration;
import GCS.GCS_GAdministation.entity.Utilisateur;
import GCS.GCS_GAdministation.entity.UtilisateurResponse;
import GCS.GCS_GAdministation.repository.AdministrationRepository;
import GCS.GCS_GAdministation.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class AdministrationService {

    @Autowired
    private RestTemplate restTemplate;
    private final String URL = "http://localhost:8888/SERVICE-Administration/GCS/administration";









}
