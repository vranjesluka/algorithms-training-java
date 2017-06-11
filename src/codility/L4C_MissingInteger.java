package codility;

/**
 * Created by vranjesluka on 11/06/2017.
 */
public class L4C_MissingInteger {

    //Forth lesson C
    public int solution(int[] numbers) {
        // write your code in Java SE 8
        boolean[] isInArray = new boolean[numbers.length];
        for (int number : numbers) {
            if (number > 0 && number <= isInArray.length) {
                isInArray[number - 1] = true;
            }
        }
        for (int i = 0; i < isInArray.length; i++) {
            if (!isInArray[i]) {
                return i + 1;
            }
        }
        return isInArray.length + 1;
    }

    public static void main(String[] args) {
        L4C_MissingInteger solution = new L4C_MissingInteger();
        System.out.println(solution.solution(new int[]{1}));
    }
}
