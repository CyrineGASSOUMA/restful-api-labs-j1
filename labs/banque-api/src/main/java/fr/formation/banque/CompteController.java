package fr.formation.banque;

import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/comptes")
public class CompteController {

    // "Base de données" en mémoire : elle sera remplacée par JPA au jour 2
    private final Map<Long, Compte> comptes = new ConcurrentHashMap<>();
    private final AtomicLong sequence = new AtomicLong();

    public CompteController() {
        enregistrer(new Compte(null, "Alice Martin", "COURANT", 1500));
        enregistrer(new Compte(null, "Bob Durand", "EPARGNE", 12000));
        enregistrer(new Compte(null, "Chloé Petit", "COURANT", 80));
        enregistrer(new Compte(null, "David Leroy", "EPARGNE", 450));
    }

    private Compte enregistrer(Compte compte) {
        compte.setId(sequence.incrementAndGet());
        comptes.put(compte.getId(), compte);
        return compte;
    }

    // Étape 1 : GET /comptes renvoie tous les comptes
    @GetMapping
    public List<Compte> lister() {
        // TODO étape 1
        return List.of();
    }

    // Étapes 2 à 5 : à écrire (voir énoncé)
}
