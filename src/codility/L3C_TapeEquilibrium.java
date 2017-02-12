package codility;

/**
 * Created by vranjesluka on 04/02/2017.
 */
public class L3C_TapeEquilibrium {

    //Third lesson C
    public int solution(int[] A) {
        // write your code in Java SE 8

        int[] sumsLeft = new int[A.length];
        sumsLeft[0] = 0;
        for (int i = 1; i < A.length; i++) {
            sumsLeft[i] = sumsLeft[i - 1] + A[i - 1];
        }
        int sumRight = 0;
        int minDiff = Integer.MAX_VALUE;
        for (int i = A.length - 1; i > 0; i--) {
            sumRight += A[i];
            int currentDiff = Math.abs(sumRight - sumsLeft[i]);
            if (minDiff > currentDiff) {
                minDiff = currentDiff;
            }
        }
        return minDiff;
    }

    public static void main(String[] args) {
        L3C_TapeEquilibrium solution = new L3C_TapeEquilibrium();
        System.out.println(solution.solution(new int[]{3, 4, 4, 6, 1, 4, 4}));
    }
}
