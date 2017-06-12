package codility;

/**
 * Created by vranjesluka on 12/06/2017.
 */
public class L5A_CountDiv {

    public int solution(int low, int high, int divider) {
        // write your code in Java SE 8
        int divHigh = high / divider;
        int divLow = low / divider;
        if (low % divider == 0) {
            return divHigh - divLow + 1;
        } else {
            return divHigh - divLow;
        }
    }

    public static void main(String[] args) {
        L5A_CountDiv solution = new L5A_CountDiv();
        System.out.println(solution.solution(6, 11, 2));
    }

}
