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

        Stack<T> enqueueStack = new Stack<>();
        Stack<T> dequeueStack = new Stack<>();

        public void enqueue(T element) {
            enqueueStack.push(element);
        }

        public T dequeue() {
            if (!dequeueStack.empty()) {
                return dequeueStack.pop();
            }
            while (!enqueueStack.empty()) {
                dequeueStack.push(enqueueStack.pop());
            }
            return dequeueStack.pop();
        }

        public T peek() {
            if (!dequeueStack.empty()) {
                return dequeueStack.peek();
            }
            while (!enqueueStack.empty()) {
                dequeueStack.push(enqueueStack.pop());
            }
            return dequeueStack.peek();
        }
    }
}
