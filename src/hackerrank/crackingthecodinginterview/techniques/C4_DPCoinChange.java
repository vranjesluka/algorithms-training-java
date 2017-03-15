package hackerrank.crackingthecodinginterview.techniques;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by vranjesluka on 15/03/2017.
 */
public class C4_DPCoinChange {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int coins[] = new int[m];
        for (int coins_i = 0; coins_i < m; coins_i++) {
            coins[coins_i] = in.nextInt();
        }
        System.out.println(waysToChange(n, 0, coins, new HashMap<>()));
    }

    private static long waysToChange(int n, int startingCoin, int[] coins, Map<String, Long> waysToChangeTable) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        String key = n + "-" + startingCoin;
        if (waysToChangeTable.containsKey(key)) {
            return waysToChangeTable.get(key);
        }
        long waysToChange = 0;
        for (int i = startingCoin; i < coins.length; i++) {
            waysToChange += waysToChange(n - coins[i], i, coins, waysToChangeTable);
        }
        waysToChangeTable.put(key, waysToChange);
        return waysToChange;
    }
}
