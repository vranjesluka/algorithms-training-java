package codility;

/**
 * Created by vranjesluka on 08/06/2017.
 */
public class L4A_PermCheck {

    //Forth lesson A
    public int solution(int[] A) {
        // write your code in Java SE 8
        return isPermutation(A) ? 1 : 0;
    }

    private boolean isPermutation(int[] permutationArray) {
        boolean[] hasNumber = new boolean[permutationArray.length];
        for (int number : permutationArray) {
            if (number > permutationArray.length || hasNumber[number - 1]) {
                return false;
            } else {
                hasNumber[number - 1] = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        L4A_PermCheck solution = new L4A_PermCheck();
        System.out.println(solution.solution(new int[]{4, 1, 2}));
    }
}
