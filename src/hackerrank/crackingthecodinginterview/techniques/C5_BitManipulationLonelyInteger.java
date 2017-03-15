package hackerrank.crackingthecodinginterview.techniques;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by vranjesluka on 15/03/2017.
 */
public class C5_BitManipulationLonelyInteger {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        for (int a_i = 0; a_i < n; a_i++) {
            a[a_i] = in.nextInt();
        }
        System.out.println(getLonelyIntegerBetter(a));
    }

    //https://www.hackerrank.com/challenges/ctci-lonely-integer/editorial
    private static int getLonelyIntegerBetter(int[] array) {
        int result = 0;
        for(int i : array) {
            result = result ^ i;
        }
        return result;
    }

    private static int getLonelyInteger(int[] array) {
        Set<Integer> unpairedNumbers = new HashSet<>();
        for (int value : array) {
            if (unpairedNumbers.contains(value)) {
                unpairedNumbers.remove(value);
            } else {
                unpairedNumbers.add(value);
            }
        }
        return unpairedNumbers.iterator().next();
    }
}
