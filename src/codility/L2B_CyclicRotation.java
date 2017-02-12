package codility;

import java.util.Arrays;

/**
 * Created by vranjesluka on 04/02/2017.
 */
public class L2B_CyclicRotation {

    //Second lesson B
    public int[] solution(int[] A, int K) {
        // write your code in Java SE 8
        if (A == null || A.length <= 1) {
            return A;
        }
        int[] unmodifiedA = Arrays.copyOf(A, A.length);
        for (int i = 0; i < A.length; i++) {
            int indexShifted = (i + K) % A.length;
            A[indexShifted] = unmodifiedA[i];
        }
        return A;
    }

    public static void main(String[] args) {
        L2B_CyclicRotation solution = new L2B_CyclicRotation();
        System.out.println(Arrays.toString(solution.solution(new int[]{3, 4, 4, 6, 1, 4, 4}, 5)));
    }
}
