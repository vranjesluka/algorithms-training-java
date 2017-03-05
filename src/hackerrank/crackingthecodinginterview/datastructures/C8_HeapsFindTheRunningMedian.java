package hackerrank.crackingthecodinginterview.datastructures;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by vranjesluka on 05/03/2017.
 */
public class C8_HeapsFindTheRunningMedian {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int a_i = 0; a_i < n; a_i++) {
            a[a_i] = in.nextInt();
        }
        PriorityQueue<Integer> bigMinPriorityQueue = new PriorityQueue<>(n / 2);
        PriorityQueue<Integer> smallMaxPriorityQueue = new PriorityQueue<>(n / 2, Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            if (bigMinPriorityQueue.isEmpty()) {
                bigMinPriorityQueue.add(a[i]);
                System.out.println((float) bigMinPriorityQueue.peek());
            } else {
                if (i % 2 == 0) {
                    int maxSmall = smallMaxPriorityQueue.peek();
                    int currentChanging = a[i];
                    if (maxSmall > currentChanging) {
                        smallMaxPriorityQueue.add(currentChanging);
                        currentChanging = smallMaxPriorityQueue.poll();
                    }
                    bigMinPriorityQueue.add(currentChanging);
                    System.out.println((float) bigMinPriorityQueue.peek());
                } else {
                    int minBig = bigMinPriorityQueue.peek();
                    int currentChanging = a[i];
                    if (minBig < currentChanging) {
                        bigMinPriorityQueue.add(currentChanging);
                        currentChanging = bigMinPriorityQueue.poll();
                    }
                    smallMaxPriorityQueue.add(currentChanging);
                    System.out.println(((float) bigMinPriorityQueue.peek() + smallMaxPriorityQueue.peek()) / 2);
                }
            }
        }
    }
}
