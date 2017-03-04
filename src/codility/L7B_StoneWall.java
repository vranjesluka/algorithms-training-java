package codility;

import java.util.Stack;

/**
 * Created by vranjesluka on 04/03/2017.
 */
public class L7B_StoneWall {


    public int solution(int[] H) {
        // write your code in Java SE 8
        int blockCounter = 0;
        Stack<Integer> heights = new Stack<>();
        int formerHeight = 0;
        for (int height : H) {
            if (height > formerHeight) {
                blockCounter++;
                heights.push(height);
            } else if (height < formerHeight) {
                int currentHeight = heights.pop();
                while (!heights.empty() && (currentHeight = heights.peek()) > height) {
                    currentHeight = heights.pop();
                }
                if (currentHeight != height) {
                    blockCounter++;
                    heights.push(height);
                }
            }
            formerHeight = height;
        }
        return blockCounter;
    }

    public static void main(String[] args) {
        L7B_StoneWall solution = new L7B_StoneWall();
        System.out.println(solution.solution(new int[]{8, 8, 5, 7, 9, 8, 7, 4, 8}));
    }

}
