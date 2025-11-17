package Exercice_2;

public class ex2 {
    public static void main(int n) {
        if (n == 0)
            return;
        System.out.println(Fibonacci(n+1)/Fibonacci(n));
        System.out.println(GoldenRatio());
    }
    public static int Fibonacci(int n) {
        if (n <= 0)
            return 0;
        else if (n == 1)
            return 1;
        else
            return Fibonacci(n - 1) + Fibonacci(n - 2);
    }
    public static double GoldenRatio() {
        return 1+Math.sqrt(5)/2;
    }
}