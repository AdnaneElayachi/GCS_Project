package GCS.GCS_Payement.controllers;

import GCS.GCS_Payement.entites.Paiement;
import GCS.GCS_Payement.services.PaiementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gcs/Paiement/")
public class PaiementControllers {
    private PaiementService paiementService;
    @PostMapping("/ajouter")
    public ResponseEntity<String> AjouterPaiement(@RequestBody Double montant) {
        Paiement paiement = paiementService.AjouterPaiement(montant);
        return ResponseEntity.ok(". Payment ID: " + paiement.getId());
    }
}
