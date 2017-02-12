package codility;

/**
 * Created by vranjesluka on 04/02/2017.
 */
public class L1_BinaryGap {
    //first lesson
    public int solution(int N) {
        // write your code in Java SE 8
        int exponentOfTwo = 1;
        int maxCount = 0;
        int currentCount = 0;
        boolean isInGap = false;
        while (N / exponentOfTwo > 0) {
            int currentByte = (N / exponentOfTwo) % 2;
            if (!isInGap && currentByte == 1) {
                isInGap = true;
            } else if (isInGap && currentByte == 0) {
                currentCount++;
            } else if (currentByte == 1) {
                if (maxCount < currentCount) {
                    maxCount = currentCount;
                }
                currentCount = 0;
            }
            exponentOfTwo *= 2;
        }
        return maxCount;
    }

    public static void main(String[] args) {
        L1_BinaryGap solution = new L1_BinaryGap();
        System.out.println(solution.solution(1041));
    }
}
