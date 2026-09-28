package fr.formation.banque;

public class Compte {
    private Long id;
    private String titulaire;
    private String type;   // COURANT ou EPARGNE
    private double solde;

    public Compte() { }

    public Compte(Long id, String titulaire, String type, double solde) {
        this.id = id;
        this.titulaire = titulaire;
        this.type = type;
        this.solde = solde;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitulaire() { return titulaire; }
    public void setTitulaire(String titulaire) { this.titulaire = titulaire; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public double getSolde() { return solde; }
    public void setSolde(double solde) { this.solde = solde; }
}
