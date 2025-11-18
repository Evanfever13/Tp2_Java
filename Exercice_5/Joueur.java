package Exercice_5;

public class Joueur {
    private String a_nom;
    private String a_prenom;
    private String a_pseudo;
    private Resultat a_resultat;

    public Joueur() {
        this.a_nom = "";
        this.a_prenom = "";
        this.a_pseudo = "";
        this.a_resultat = new Resultat();
    }

    public Joueur(String nom, String prenom, String pseudo, Resultat resultat) {
        this.a_nom = nom;
        this.a_prenom = prenom;
        this.a_pseudo = pseudo;
        this.a_resultat = resultat;
    }

    public String getNom() { return a_nom; }
    public String getPrenom() { return a_prenom; }
    public String getPseudo() { return a_pseudo; }
    public Resultat getResultat() { return a_resultat; }

    public void setNom(String nom) {
        if (nom != null && !nom.trim().isEmpty()) this.a_nom = nom;
    }
    public void setPrenom(String prenom) {
        if (prenom != null && !prenom.trim().isEmpty()) this.a_prenom = prenom;
    }
    public void setPseudo(String pseudo) {
        if (pseudo != null && !pseudo.trim().isEmpty()) this.a_pseudo = pseudo;
    }
    public void setResultat(Resultat resultat) { this.a_resultat = resultat; }

    public void afficher() {
        System.out.println("Nom : " + a_nom);
        System.out.println("Prenom : " + a_prenom);
        System.out.println("Pseudo : " + a_pseudo);
        if (a_resultat != null) a_resultat.afficher();
    }

    @Override
    public String toString() {
        return a_nom + " " + a_prenom + " (" + a_pseudo + ") - " +
               (a_resultat != null ? a_resultat.toString() : "Score : 0");
    }
}