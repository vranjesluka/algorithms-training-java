package hackerrank.crackingthecodinginterview.algorithms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by vranjesluka on 14/03/2017.
 */
public class C2_SortingComparator {

    private static class Checker implements Comparator<Player>{

        @Override
        public int compare(Player first, Player second) {
            if (first.score != second.score) {
                return second.score - first.score;
            } else {
                return first.name.compareTo(second.name);
            }
        }
    }

    private static class Player {
        String name;
        int score;

        Player(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();

        for (int i = 0; i < n; i++) {
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();

        Arrays.sort(player, checker);
        for (int i = 0; i < player.length; i++) {
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }
}
