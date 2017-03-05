package hackerrank.crackingthecodinginterview.datastructures;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by vranjesluka on 05/03/2017.
 */
public class C5_StacksBalancedBrackets {

    private static boolean isOpenBracket(char openBracket) {
        return openBracket == '('
                || openBracket == '['
                || openBracket == '{';
    }

    private static boolean isCloseBracket(char closeBracket) {
        return closeBracket == ')'
                || closeBracket == ']'
                || closeBracket == '}';
    }

    private static boolean isPairOfBrackets(char openBracket, char closeBracket) {
        return openBracket == '(' && closeBracket == ')'
                || openBracket == '[' && closeBracket == ']'
                || openBracket == '{' && closeBracket == '}';
    }

    public static boolean isBalanced(String expression) {
        Stack<Character> stackOfBrackets = new Stack<>();
        for (char bracket : expression.toCharArray()) {
            if (isOpenBracket(bracket)) {
                stackOfBrackets.push(bracket);
            } else if (isCloseBracket(bracket)) {
                if (stackOfBrackets.empty()) {
                    return false;
                }
                char openBracket = stackOfBrackets.pop();
                if (!isPairOfBrackets(openBracket, bracket)) {
                    return false;
                }
            }
        }
        return stackOfBrackets.empty();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println( (isBalanced(expression)) ? "YES" : "NO" );
        }
    }
}
