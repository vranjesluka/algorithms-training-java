package codility;

import java.util.Arrays;

/**
 * Created by vranjesluka on 04/02/2017.
 */
public class L4D_MaxCounters {


    //Forth lesson D
    public int[] solution(int N, int[] A) {
        // write your code in Java SE 8
        int[] counters = new int[N];
        int maxCounter = 0;
        int nominalMaxCounter = 0;
        for (int incrementCounter : A) {
            if (incrementCounter > N) {
                nominalMaxCounter = maxCounter;
            } else {
                if (counters[incrementCounter - 1] < nominalMaxCounter) {
                    counters[incrementCounter - 1] = nominalMaxCounter;
                }
                counters[incrementCounter - 1]++;
                if (maxCounter < counters[incrementCounter - 1]) {
                    maxCounter = counters[incrementCounter - 1];
                }
            }
        }
        for (int i = 0; i < N; i++) {
            if (counters[i] < nominalMaxCounter) {
                counters[i] = nominalMaxCounter;
            }
        }
        return counters;
    }

    public static void main(String[] args) {
        L4D_MaxCounters solution = new L4D_MaxCounters();
        System.out.println(Arrays.toString(solution.solution(5, new int[]{3, 4, 4, 6, 1, 4, 4})));
    }
}
