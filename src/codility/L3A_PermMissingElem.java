package codility;

/**
 * Created by vranjesluka on 19/05/2017.
 */
public class L3A_PermMissingElem {

    //Third lesson A
    public int solution(int[] A) {
        // write your code in Java SE 8
        long maxNumber = A.length + 1;
        long missingNumber = maxNumber * (maxNumber + 1) / 2;
        for (int number : A) {
            missingNumber -= number;
        }
        return (int) missingNumber;
    }

    public static void main(String[] args) {
        L3A_PermMissingElem solution = new L3A_PermMissingElem();
        System.out.println(solution.solution(new int[]{2, 3, 1, 5}));
    }
}
