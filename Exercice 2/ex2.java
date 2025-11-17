public class ex2 {
    public static void main(String[] args) {
        if (args == null || args.length != 1 || args[0] == "0")
            return;
        System.out.println(Fibonacci(Integer.parseInt(args[0])+1)/Fibonacci(Integer.parseInt(args[0])));
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