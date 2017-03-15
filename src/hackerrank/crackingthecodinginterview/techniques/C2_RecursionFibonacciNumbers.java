package hackerrank.crackingthecodinginterview.techniques;

import java.util.Scanner;

/**
 * Created by vranjesluka on 15/03/2017.
 */
public class C2_RecursionFibonacciNumbers {

    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        System.out.println(fibonacci(n));
    }
}
