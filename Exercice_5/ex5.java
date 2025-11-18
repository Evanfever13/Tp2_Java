package Exercice_5;

public class ex5 {
    public static void main(String[] args) {
        Resultat r1 = new Resultat(120);
        Joueur j1 = new Joueur("Toto", "Tata", "GARMIN", r1);

        Resultat r2 = new Resultat();
        r2.setScore(85);
        Joueur j2 = new Joueur("Evan","Michel","Marc",r2);

        System.out.println("Affichage avec afficher():");
        j1.afficher();
        System.out.println();
        j2.afficher();

        System.out.println("\nAffichage avec toString():");
        System.out.println(j1);
        System.out.println(j2);
    }
}

