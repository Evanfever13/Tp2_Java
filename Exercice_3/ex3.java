package Exercice_3;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.Scanner;

public class ex3 {
    public static void main(String[] args) {
        try {
            // gestion d'erreur pour le texte
            System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8.name()));
            System.setErr(new PrintStream(System.err, true, StandardCharsets.UTF_8.name()));
        } catch (UnsupportedEncodingException e) {
        }

        Scanner input = new Scanner(System.in, StandardCharsets.UTF_8.name());
        Random rnd = new Random();
        int maxPerTurn = 3;

        try {
            System.out.print("Entrez votre nom: ");
            String nom = input.nextLine().trim();
            if (nom.isEmpty()) nom = "Joueur";
            System.out.println("Votre nom est " + nom);

            int debut = readPositiveInt(input, "Choisir le nombre d'allumettes de depart (>=1): ");

            System.out.println("Le nombre d'allumettes de depart est " + debut);
            System.out.println("L'ordinateur commence");

            while (debut > 0) { 
                // boucle jusqu'a qu'il n'y a plus d'allumettes
                int ordinateur = ia(debut, rnd, maxPerTurn);
                debut -= ordinateur;
                System.out.println("Ordinateur enleve: " + ordinateur);

                if (debut <= 1) {
                    System.out.println("Ordinateur a gagne :-)");
                    System.out.println(nom + " a perdu :-(");
                    break;
                }
                System.out.println("Allumettes restantes: " + debut);

                int maxPrise = Math.min(maxPerTurn, debut);
                int joueur = readBoundedInt(input,
                        String.format("%s, choisis un nombre (1..%d): ", nom, maxPrise),
                        1, maxPrise);
                joueur = Math.min(joueur, debut);
                debut -= joueur;
                System.out.println(nom + " enleve: " + joueur);

                if (debut <= 1) {
                    System.out.println(nom + " a gagne :-)");
                    System.out.println("Ordinateur a perdu :-(");
                    break;
                }
                System.out.println("Allumettes restantes: " + debut);
            }

        } catch (Exception e) {
            // gestion d'erreur
            System.out.println("Une erreur est survenue: " + e.getMessage());
        }
    }

    private static int ia(int debut, Random rnd, int maxPerTurn) {
        // ia qui joue contre l'utilisateur
        int maxTake = Math.min(maxPerTurn, debut);
        if (debut <= maxPerTurn) return debut;
        int mod = debut % (maxPerTurn + 1);
        if (mod == 0) {
            return rnd.nextInt(maxTake) + 1;
        } else {
            return Math.min(mod, maxTake);
        }
    }

    private static int readPositiveInt(Scanner input, String prompt) {
        // verifie que le nombre soit rentre par le joueur est bien positive
        while (true) {
            System.out.print(prompt);
            String line = input.nextLine().trim();
            try {
                int valeur = Integer.parseInt(line);
                if (valeur >= 1) return valeur;
                System.out.println("Veuillez entrer un entier >= 1.");
            } catch (NumberFormatException e) {
                System.out.println("Entree invalide. Entrez un entier.");
            }
        }
    }

    private static int readBoundedInt(Scanner input, String prompt, int min, int max) {
        // verifie le nombre que le joueur rentre, si le joueur rentre un nombre superieur ou inferieur au valeur qui doit rentrer
        while (true) {
            System.out.print(prompt);
            String line = input.nextLine().trim();
            try {
                int valeur = Integer.parseInt(line);
                if (valeur < min) {
                    System.out.println("Trop petit, valeur minimale: " + min);
                    continue;
                }
                if (valeur > max) {
                    System.out.println("Trop grand, valeur maximale: " + max);
                    continue;
                }
                return valeur;
            } catch (NumberFormatException e) {
                System.out.println("Entree invalide. Entrez un entier.");
            }
        }
    }
}