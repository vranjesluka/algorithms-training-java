package codility;

/**
 * Created by vranjesluka on 19/05/2017.
 */
public class L3B_FrogJmp {

    //Third lesson A
    public int solution(int X, int Y, int D) {
        // write your code in Java SE 8
        return (int) Math.ceil((double) (Y - X) / D);
    }

    public static void main(String[] args) {
        L3B_FrogJmp solution = new L3B_FrogJmp();
        System.out.println(solution.solution(10, 85, 30));
    }
}
