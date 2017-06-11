package codility;

/**
 * Created by vranjesluka on 11/06/2017.
 */
public class L4B_FrogRiverOne {

    //Forth lesson B
    public int solution(int width, int[] leafPositions) {
        // write your code in Java SE 8
        boolean[] isLeafInPosition = new boolean[width];
        int numberOfUnleafedPositions = width;
        for (int i = 0; i < leafPositions.length; i++) {
            int newLeafPosition = leafPositions[i] - 1;
            if (!isLeafInPosition[newLeafPosition]) {
                isLeafInPosition[newLeafPosition] = true;
                numberOfUnleafedPositions--;
                if (numberOfUnleafedPositions < 1) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        L4B_FrogRiverOne solution = new L4B_FrogRiverOne();
        System.out.println(solution.solution(5, new int[]{1, 3, 1, 4, 2, 3, 5, 4}));
    }
}
