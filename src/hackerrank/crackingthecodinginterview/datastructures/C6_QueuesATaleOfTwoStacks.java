package hackerrank.crackingthecodinginterview.datastructures;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by vranjesluka on 05/03/2017.
 */
public class C6_QueuesATaleOfTwoStacks {

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }

    private static class MyQueue<T> {

        Stack<T> stack = new Stack<>();

        public void enqueue(T element) {
            stack.push(element);
        }

        public T dequeue() {
            Stack<T> helperStack = new Stack<>();
            while (!stack.empty()) {
                helperStack.push(stack.pop());
            }
            T element = helperStack.pop();
            while (!helperStack.empty()) {
                stack.push(helperStack.pop());
            }
            return element;
        }

        public T peek() {
            Stack<T> helperStack = new Stack<>();
            while (!stack.empty()) {
                helperStack.push(stack.pop());
            }
            T element = helperStack.peek();
            while (!helperStack.empty()) {
                stack.push(helperStack.pop());
            }
            return element;
        }
    }
}
