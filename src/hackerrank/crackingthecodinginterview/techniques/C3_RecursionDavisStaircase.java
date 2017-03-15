package hackerrank.crackingthecodinginterview.techniques;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by vranjesluka on 15/03/2017.
 */
public class C3_RecursionDavisStaircase {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        Map<Integer, Integer> waysToClimbTable = new HashMap<>();
        for (int a0 = 0; a0 < s; a0++) {
            int n = in.nextInt();
            System.out.println(waysToClimb(n, waysToClimbTable));
        }
    }

    private static int waysToClimb(int n, Map<Integer, Integer> waysToClimbTable) {
        if (n <= 2) {
            return n;
        }
        if (n == 3) {
            return 4;
        }
        if (waysToClimbTable.containsKey(n)) {
            return waysToClimbTable.get(n);
        } else {
            int waysToClimb = waysToClimb(n - 1, waysToClimbTable)
                    + waysToClimb(n - 2, waysToClimbTable)
                    + waysToClimb(n - 3, waysToClimbTable);
            waysToClimbTable.put(n, waysToClimb);
            return waysToClimb;
        }
    }
}
