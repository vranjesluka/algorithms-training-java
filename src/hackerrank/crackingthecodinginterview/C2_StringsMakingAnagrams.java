package hackerrank.crackingthecodinginterview;

import java.util.Scanner;

/**
 * Created by vranjesluka on 05/03/2017.
 */
public class C2_StringsMakingAnagrams {

    public static final int FIRST_LETTER_CODE = 97;
    public static final int NUMBER_OF_LETTERS = 26;

    public static int numberNeeded(String first, String second) {
        int[] countersOfCharsFirst = new int[NUMBER_OF_LETTERS];
        int[] countersOfCharsSecond = new int[NUMBER_OF_LETTERS];
        for (char current : first.toCharArray()) {
            countersOfCharsFirst[current - FIRST_LETTER_CODE]++;
        }
        for (char current : second.toCharArray()) {
            countersOfCharsSecond[current - FIRST_LETTER_CODE]++;
        }

        int numberNeeded = 0;
        for (int i = 0; i < NUMBER_OF_LETTERS; i++) {
            numberNeeded += Math.abs(countersOfCharsFirst[i] - countersOfCharsSecond[i]);
        }
        return numberNeeded;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}
