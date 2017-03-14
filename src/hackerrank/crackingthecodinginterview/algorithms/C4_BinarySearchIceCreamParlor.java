package hackerrank.crackingthecodinginterview.algorithms;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by vranjesluka on 14/03/2017.
 */
public class C4_BinarySearchIceCreamParlor {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            int m = in.nextInt();
            int n = in.nextInt();
            int a[] = new int[n];
            for (int a_i = 0; a_i < n; a_i++) {
                a[a_i] = in.nextInt();
            }
            int[] sortedArray = new int[n];
            System.arraycopy(a, 0, sortedArray, 0, a.length);
            Arrays.sort(sortedArray);

            int lastIndex = sortedArray.length - 1;
            for (int i = 0; i < sortedArray.length; i++) {
                if (m < sortedArray[i]) {
                    lastIndex = i;
                    break;
                }
            }

            int firstValue = 0;
            int secondValue = 0;
            for (int i = 0; i < lastIndex; i++) {
                if (binarySearchRecursive(sortedArray, m - sortedArray[i], i, lastIndex) != -1) {
                    firstValue = sortedArray[i];
                    secondValue = m - sortedArray[i];
                    break;
                }
            }

            printValuesIndexes(a, firstValue, secondValue);
        }
    }

    private static int binarySearchRecursive(int[] sortedArray, int value, int start, int end) {
        if (start > end) {
            return -1;
        }
        int midIndex = start + ((end - start) / 2);

        // If value is found
        if (value == sortedArray[midIndex]) {
            return midIndex;
        } else {
            // if value < sortedArray[midIndex], search start
            if (value < sortedArray[midIndex]) {
                end = midIndex - 1;
            } else { // if value > sortedArray[midIndex], search end
                start = midIndex + 1;
            }

            return binarySearchRecursive(sortedArray, value, start, end);
        }
    }

    private static void printValuesIndexes(int[] a, int firstValue, int secondValue) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == firstValue || a[i] == secondValue) {
                System.out.print("" + (i + 1) + " ");
                if (a[i] == firstValue) {
                    firstValue = -1;
                    if (secondValue == -1) {
                        break;
                    }
                } else {
                    secondValue = -1;
                    if (firstValue == -1) {
                        break;
                    }
                }
            }
        }
        System.out.println();
    }
}
