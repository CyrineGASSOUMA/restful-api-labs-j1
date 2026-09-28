package fr.formation.banque;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/comptes")
public class CompteController {

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

    @GetMapping
    public List<Compte> lister() {
        return new ArrayList<>(comptes.values());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Compte> lire(@PathVariable Long id) {
        Compte compte = comptes.get(id);
        return compte == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(compte);
    }

    @PostMapping
    public ResponseEntity<Compte> creer(@RequestBody Compte compte, UriComponentsBuilder uri) {
        if (compte.getTitulaire() == null || compte.getTitulaire().isBlank()) {
            return ResponseEntity.badRequest().build();          // bonus B1
        }
        Compte cree = enregistrer(compte);
        URI location = uri.path("/comptes/{id}").buildAndExpand(cree.getId()).toUri();
        return ResponseEntity.created(location).body(cree);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Compte> remplacer(@PathVariable Long id, @RequestBody Compte compte) {
        if (!comptes.containsKey(id)) {
            return ResponseEntity.notFound().build();
        }
        compte.setId(id);
        comptes.put(id, compte);
        return ResponseEntity.ok(compte);
    }

    @PatchMapping("/{id}")                                         // bonus B2
    public ResponseEntity<Compte> modifierTitulaire(@PathVariable Long id, @RequestBody Map<String, String> champs) {
        Compte compte = comptes.get(id);
        if (compte == null) {
            return ResponseEntity.notFound().build();
        }
        if (champs.containsKey("titulaire")) {
            compte.setTitulaire(champs.get("titulaire"));
        }
        return ResponseEntity.ok(compte);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimer(@PathVariable Long id) {
        return comptes.remove(id) == null ? ResponseEntity.notFound().build() : ResponseEntity.noContent().build();
    }
}
