package hackerrank.crackingthecodinginterview.algorithms;

import java.util.Scanner;

/**
 * Created by vranjesluka on 14/03/2017.
 */
public class C3_MergeSortCountingInversions {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            int n = in.nextInt();
            int arr[] = new int[n];
            for (int arr_i = 0; arr_i < n; arr_i++) {
                arr[arr_i] = in.nextInt();
            }
            System.out.println(getNumberOfSwapsToSort(arr, new int[n], 0, arr.length - 1));
        }
    }

    private static long getNumberOfSwapsToSort(int[] array, int[] temp, int start, int end) {
        if (start >= end) {
            return 0;
        }
        int middle = (end + start) / 2;
        long numberOfSwaps = getNumberOfSwapsToSort(array, temp, start, middle)
                + getNumberOfSwapsToSort(array, temp, middle + 1, end);
        numberOfSwaps += getNumberOfSwapsToMerge(array, temp, start, end);
        return numberOfSwaps;
    }

    private static long getNumberOfSwapsToMerge(int[] array, int[] temp, int leftStart, int rightEnd) {
        int leftEnd = (rightEnd + leftStart) / 2;
        int rightStart = leftEnd + 1;
        int size = rightEnd - leftStart + 1;

        long numberOfSwaps = 0;
        int left = leftStart;
        int right = rightStart;
        int index = leftStart;

        while (left <= leftEnd && right <= rightEnd) {
            if (array[left] <= array[right]) {
                temp[index] = array[left];
                left++;
            } else {
                temp[index] = array[right];
                numberOfSwaps += right - index;
                right++;
            }
            index++;
        }

        System.arraycopy(array, left, temp, index, leftEnd - left + 1);
        System.arraycopy(array, right, temp, index, rightEnd - right + 1);
        System.arraycopy(temp, leftStart, array, leftStart, size);

        return numberOfSwaps;
    }
}
