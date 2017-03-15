package hackerrank.crackingthecodinginterview.techniques;

import java.util.Scanner;

/**
 * Created by vranjesluka on 15/03/2017.
 */
public class C1_TimeComplexityPrimality {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int p = in.nextInt();
        for (int a0 = 0; a0 < p; a0++) {
            int n = in.nextInt();
            printIsPrime(isPrime(n));
        }
    }

    private static boolean isPrime(int n) {
        if (n == 2) {
            return true;
        }
        if (n <= 1 || n % 2 == 0) {
            return false;
        }
        int biggest = (int) Math.sqrt(n);
        for (int i = 3; i <= biggest; i += 2) {
            if (n % i == 0) {
                return false;
            }
            System.out.println(i);
        }
        return true;
    }

    private static void printIsPrime(boolean isPrime) {
        System.out.println(isPrime ? "Prime" : "Not prime");
    }
}
