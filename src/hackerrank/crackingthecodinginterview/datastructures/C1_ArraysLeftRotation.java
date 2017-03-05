package hackerrank.crackingthecodinginterview.datastructures;

import java.util.Scanner;

/**
 * Created by vranjesluka on 04/03/2017.
 */
public class C1_ArraysLeftRotation {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int d = in.nextInt();
        int a[] = new int[n];
        for (int a_i = 0; a_i < n; a_i++) {
            a[a_i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            int index = (d + i) % n;
            System.out.print(a[index] + " ");
        }
    }
}
