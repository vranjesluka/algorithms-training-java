package codility;

/**
 * Created by vranjesluka on 04/02/2017.
 */
public class L5D_MinAvgTwoSlice {


    public int solution(int[] A) {
        // write your code in Java SE 8
        float minAverage = Float.MAX_VALUE;
        int minAverageIndex = 0;
        for (int i = 0; i < A.length - 1; i++) {
            float sum = A[i] + A[i + 1];
            float average = sum / 2;
            if (i < A.length - 2 && A[i + 2] < average) {
                sum += A[i + 2];
                average = sum / 3;
            }
            if (minAverage > average) {
                minAverage = average;
                minAverageIndex = i;
            }
        }
        return minAverageIndex;
    }

    public static void main(String[] args) {
        L5D_MinAvgTwoSlice solution = new L5D_MinAvgTwoSlice();
        System.out.println(solution.solution(new int[]{4, 2, 2, 5, 1, 5, 8}));
    }

}
