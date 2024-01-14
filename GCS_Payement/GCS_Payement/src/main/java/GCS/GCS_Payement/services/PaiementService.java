package GCS.GCS_Payement.services;

import GCS.GCS_Payement.entites.Etudiant;
import GCS.GCS_Payement.entites.Paiement;
import GCS.GCS_Payement.repository.PaiementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaiementService {

    private final PaiementRepository paiementRepository;
    private final String URLGroups = "http://localhost:8888/SERVICE-GCS_Paiement";


    @Autowired
    public PaiementService(PaiementRepository paiementRepository) {
        this.paiementRepository = paiementRepository;
    }

    public Paiement AjouterPaiement(Double montant) {
        Paiement paiement = new Paiement();
        paiement.setMontant(montant);
        return paiementRepository.save(paiement);
    }

    public List<Paiement> getAllPayments() {
        return paiementRepository.findAll();
    }
    public List<Etudiant> getEtudiantsAvecPaiement() {
        List<Paiement> paiements = paiementRepository.findAll();

        return paiements.stream()
                .map(Paiement::getEtudiant)
                .distinct()
                .toList();
    }
}
