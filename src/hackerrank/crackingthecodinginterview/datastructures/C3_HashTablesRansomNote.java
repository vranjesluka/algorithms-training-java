package hackerrank.crackingthecodinginterview.datastructures;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by vranjesluka on 05/03/2017.
 */
public class C3_HashTablesRansomNote {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        Map<String, Integer> magazineWords = new HashMap<>(m);
        for (int magazine_i = 0; magazine_i < m; magazine_i++) {
            String currentWord = in.next();
            if (magazineWords.containsKey(currentWord)) {
                int currentNumber = magazineWords.get(currentWord) + 1;
                magazineWords.put(currentWord, currentNumber);
            } else {
                magazineWords.put(currentWord, 1);
            }
        }
        boolean canWrite = true;
        for (int ransom_i = 0; ransom_i < n; ransom_i++) {
            String currentWord = in.next();
            if (!magazineWords.containsKey(currentWord) || magazineWords.get(currentWord) < 1) {
                canWrite = false;
                break;
            } else {
                int currentNumber = magazineWords.get(currentWord) - 1;
                magazineWords.put(currentWord, currentNumber);
            }
        }
        if (canWrite) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
