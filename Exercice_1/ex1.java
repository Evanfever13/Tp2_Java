package Exercice_1;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ex1 {
    public static int fib(int n) {
        // programme de calcul du nombre de fibonacci
        if (n <= 0) return 0;
        if (n == 1) return 1;
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        // programme qui prend en compte l'entree de l'utilisateur et lui trouve son nombre de fibonacci associe au nombre choisis
        Scanner input = new Scanner(System.in, StandardCharsets.UTF_8.name());
        System.out.print("Entrez votre nombre: ");
        String line = input.nextLine().trim();
        int nombre;
        try {
            nombre = Integer.parseInt(line);
        } catch (NumberFormatException e) {
            System.out.println("Entree invalide, veuillez entrer un entier.");
            return;
        }
        System.out.println("Fibonacci de " + nombre + " est " + fib(nombre) +" = F["+ nombre +"] = " + fib(nombre));
    }
}
