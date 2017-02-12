package codility;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by vranjesluka on 04/02/2017.
 */
public class L2A_OddOccurrencesInArray {

    //Second lesson A
    public int solution(int[] A) {
        // write your code in Java SE 8
        Set<Integer> unpairedNumbers = new HashSet<>();
        for (int value : A) {
            if (unpairedNumbers.contains(value)) {
                unpairedNumbers.remove(value);
            } else {
                unpairedNumbers.add(value);
            }
        }
        return unpairedNumbers.iterator().next();
    }

    public static void main(String[] args) {
        L2A_OddOccurrencesInArray solution = new L2A_OddOccurrencesInArray();
        System.out.println(solution.solution(new int[]{3, 4, 4, 6, 1, 4, 4}));
    }
}
