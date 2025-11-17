import Exercice_2.ex2;
import java.util.Scanner;

class Executable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Quel Exercice ?: \n");
        System.out.print("1 : Fibonacci \n");
        System.out.print("2 : Fibonacci et le Nombre d'Or \n");
        System.out.print("3 : Alumettes \n");
        System.out.print("4 : Cartes \n");
        System.out.print("5 : Joueurs \n");
        System.out.print("6 : JDialog\n");
        System.out.print("7 : JButton\n");
        System.out.print("8 : JRadioButton\n");
        System.out.print("9 : Afficher la carte\n");
        switch (scanner.next().charAt(0)) {
            case '1':
                //ex1.main();
                break;
            case '2':
                System.out.print("Entrez un nombre : ");
                int n = scanner.nextInt();
                ex2.main(n);
                break;
            case '3':
                //ex3.main();
                break;  
            case '4':
                //ex4.main();
                break;
            case '5':
                //ex4.main();
                break;
            case '6':
                //ex4.main();
                break;
            case '7':
                //ex4.main();
                break;
            case '8':
                //ex4.main();
                break;
            case '9':
                //ex4.main();
                break;
        }
    }
}