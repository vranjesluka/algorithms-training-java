package codility;

/**
 * Created by vranjesluka on 12/02/2017.
 */
public class L6D_NumberOfDiscIntersections {

    private static final int MAX_NUMBER_OF_INTERSECTING_PARIS = 10000000;

    // http://stackoverflow.com/questions/4801242/algorithm-to-calculate-number-of-intersecting-discs/16814894#16814894
    public int solution(int[] A) {
        // write your code in Java SE 8
        int result = 0;
        int[] numberOfCirclesStartingAtIndex = new int[A.length];
        int[] numberOfCirclesEndingAtIndex = new int[A.length];

        for (int i = 0, lastIndex = A.length - 1; i < A.length; i++) {
            if (i > A[i]) {
                numberOfCirclesStartingAtIndex[i - A[i]]++;
            } else {
                numberOfCirclesStartingAtIndex[0]++;
            }
            if (lastIndex - i > A[i]) {
                numberOfCirclesEndingAtIndex[i + A[i]]++;
            } else {
                numberOfCirclesEndingAtIndex[lastIndex]++;
            }
        }

        int numberOfActiveCircles = 0;
        for (int i = 0; i < A.length; i++) {
            if (numberOfCirclesStartingAtIndex[i] > 0) {
                result += numberOfActiveCircles * numberOfCirclesStartingAtIndex[i];
                result += numberOfCirclesStartingAtIndex[i] * (numberOfCirclesStartingAtIndex[i] - 1) / 2;
                numberOfActiveCircles += numberOfCirclesStartingAtIndex[i];
            }
            numberOfActiveCircles -= numberOfCirclesEndingAtIndex[i];
        }

        if (result > MAX_NUMBER_OF_INTERSECTING_PARIS) {
            return -1;
        }
        return result;
    }

    public static void main(String[] args) {
        L6D_NumberOfDiscIntersections solution = new L6D_NumberOfDiscIntersections();
        System.out.println(solution.solution(new int[]{1, 5, 2, 1, 4, 0}));
    }

}
