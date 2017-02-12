package codility;

/**
 * Created by vranjesluka on 04/02/2017.
 */
public class D1_EquilibriumIndex {

    //DEMO
    public int solution(int[] A) {
        // write your code in Java SE 8
        if (A == null || A.length <= 0) {
            return -1;
        }
        long[] sums = new long[A.length];
        sums[0] = 0;
        for (int i = 1; i < A.length; i++) {
            sums[i] = sums[i - 1] + A[i - 1];
        }
        if (sums[A.length - 1] == 0) {
            return A.length - 1;
        }
        long sumReverse = 0;
        for (int i = A.length - 2; i >= 0; i--) {
            sumReverse += A[i + 1];
            if (sumReverse == sums[i]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        D1_EquilibriumIndex solution = new D1_EquilibriumIndex();
        System.out.println(solution.solution(new int[]{3, 4, 4, 6, 1, 4, 4}));
    }

}
