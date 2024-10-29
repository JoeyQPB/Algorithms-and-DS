package joey.com.algorithms;

public class Fibonacci {

    public static int fib (int position) {
        if (position == 0) return 0;
        if (position == 1) return 1;

        int i = 1;
        int a = 0;
        int b = 1;
        int aux;
        while (i <= position) {
            aux = a;
            a = a + b;
            b = aux;
            i++;
        }
        return a;
    }

    public static int fibRec(int position) {
        if (position == 0) return 0;
        if (position == 1) return 1;
        return fibRec(position - 1) + fibRec(position - 2);
    }
}
