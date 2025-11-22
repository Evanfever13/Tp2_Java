import Exercice_1.ex1;
import Exercice_2.ex2;
import Exercice_3.ex3;
import Exercice_4.ex4;
import Exercice_5.ex5;
import Exercice_6.ex6;
import Exercice_7.ex7;
import Exercice_8.ex8;
import Exercice_9.ex9;
import java.util.Scanner;

// programme principal qui lance les differents exercices via un menu
class Executable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuer = true;
        
        while (continuer) {
            afficherMenu();
            
            // recupere le choix de l'utilisateur
            String choix = lireChoix(scanner);
            if (choix == null) continue;
            
            // execute l'exercice correspondant
            continuer = executerExercice(choix, scanner);
        }
        
        scanner.close();
        System.out.println("Programme termine.");
    }
    
    // affiche le menu des exercices disponibles
    private static void afficherMenu() {
        System.out.println("\n========== MENU PRINCIPAL ==========");
        System.out.println("1 : Fibonacci");
        System.out.println("2 : Fibonacci et le Nombre d'Or");
        System.out.println("3 : Alumettes");
        System.out.println("4 : Cartes");
        System.out.println("5 : Joueurs");
        System.out.println("6 : JDialog");
        System.out.println("7 : JButton");
        System.out.println("8 : JRadioButton");
        System.out.println("9 : Afficher la carte");
        System.out.println("0 : Quitter");
        System.out.println("====================================");
        System.out.print("Votre choix : ");
    }
    
    // lit le choix de l'utilisateur avec validation
    private static String lireChoix(Scanner scanner) {
        try {
            if (!scanner.hasNext()) {
                return null;
            }
            String choix = scanner.next().trim();
            
            if (choix.isEmpty()) {
                System.out.println("Erreur : entrez un choix valide.");
                return null;
            }
            
            return choix;
        } catch (Exception e) {
            System.out.println("Erreur de lecture : " + e.getMessage());
            return null;
        }
    }
    
    // execute l'exercice correspondant au choix
    // retourne false si l'utilisateur veut quitter
    private static boolean executerExercice(String choix, Scanner scanner) {
        char option = choix.charAt(0);
        
        try {
            switch (option) {
                case '1':
                    ex1.main(new String[]{});
                    break;
                case '2':
                    // demande un nombre pour cet exercice specifique
                    System.out.print("Entrez un nombre : ");
                    if (scanner.hasNextInt()) {
                        int n = scanner.nextInt();
                        if (n < 0) {
                            System.out.println("Erreur : nombre doit etre positif.");
                        } else {
                            ex2.main(n);
                        }
                    } else {
                        System.out.println("Erreur : nombre invalide.");
                        scanner.next(); // vider le buffer
                    }
                    break;
                case '3':
                    ex3.main(new String[]{});
                    break;
                case '4':
                    ex4.main(new String[]{});
                    break;
                case '5':
                    ex5.main(new String[]{});
                    break;
                case '6':
                    ex6.main(new String[]{});
                    break;
                case '7':
                    ex7.main(new String[]{});
                    break;
                case '8':
                    ex8.main(new String[]{});
                    break;
                case '9':
                    ex9.main(new String[]{});
                    break;
                case '0':
                case 'q':
                case 'Q':
                    System.out.println("\nAu revoir !");
                    return false;
                default:
                    System.out.println("Erreur : choix invalide (1-9 ou 0 pour quitter).");
            }
        } catch (Exception e) {
            System.out.println("Erreur lors de l'execution : " + e.getMessage());
        }
        
        return true;
    }
}