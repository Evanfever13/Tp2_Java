public class ex1 {
    public static int fib(int n){
        if (n <= 0) return 0;
        if (n == 1) return 1;
        return fib(n-1) + fib(n-2);
    }

    public static void main(String[] args){
        int n = 10;
        if (args.length > 0) {
            try { n = Integer.parseInt(args[0]); }
            catch (NumberFormatException e) { System.err.println("Nombre invalide, utilise 10"); }
        }
        System.out.println(fib(n));
    }
}