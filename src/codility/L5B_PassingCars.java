package codility;

/**
 * Created by vranjesluka on 13/06/2017.
 */
public class L5B_PassingCars {

    public int solution(int[] cars) {
        // write your code in Java SE 8
        int passingCars = 0;
        int carsGoingEast = 0;
        for (int car : cars) {
            if (car == 0) {
                carsGoingEast++;
            } else {
                passingCars += carsGoingEast;
            }
            if (passingCars > 1e9) {
                return -1;
            }
        }
        return passingCars;
    }

    public static void main(String[] args) {
        L5B_PassingCars solution = new L5B_PassingCars();
        System.out.println(solution.solution(new int[]{0, 1, 0, 1, 1}));
    }

}
