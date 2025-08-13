package SortingAlgorithm;

import java.util.Arrays;

public class TimSortOptimized {
    private static final int MIN_RUN = 32;

    // Finds the minimum run length for TimSort
    private static int minRunLength(int n) {
        int r = 0;
        while (n >= MIN_RUN) {
            r |= (n & 1);
            n >>= 1;
        }
        return n + r;
    }

    // Reverses a range in-place
    private static void reverse(int[] arr, int left, int right) {
        while (left < right) {
            int temp = arr[left];
            arr[left++] = arr[right];
            arr[right--] = temp;
        }
    }

    // Detects and sorts runs using insertion sort
    private static int countRunAndMakeAscending(int[] arr, int left, int right) {
        int runHi = left + 1;
        if (runHi == right) return 1;

        // Detect run direction
        if (arr[runHi++] < arr[left]) { // descending
            while (runHi < right && arr[runHi] < arr[runHi - 1]) {
                runHi++;
            }
            reverse(arr, left, runHi - 1);
        } else { // ascending
            while (runHi < right && arr[runHi] >= arr[runHi - 1]) {
                runHi++;
            }
        }
        return runHi - left;
    }

    // Simple insertion sort for small runs
    private static void insertionSort(int[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= left && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }

    // Merge function with temporary array reuse
    private static void merge(int[] arr, int left, int mid, int right) {
        int len1 = mid - left + 1;
        int len2 = right - mid;

        int[] leftArr = new int[len1];
        int[] rightArr = new int[len2];

        System.arraycopy(arr, left, leftArr, 0, len1);
        System.arraycopy(arr, mid + 1, rightArr, 0, len2);

        int i = 0, j = 0, k = left;
        while (i < len1 && j < len2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }
        while (i < len1) arr[k++] = leftArr[i++];
        while (j < len2) arr[k++] = rightArr[j++];
    }

    public static void timSort(int[] arr) {
        int n = arr.length;
        int minRun = minRunLength(n);

        // Sort runs with insertion sort
        for (int start = 0; start < n; ) {
            int runLen = countRunAndMakeAscending(arr, start, n);
            if (runLen < minRun) {
                int end = Math.min(start + minRun, n);
                insertionSort(arr, start, end - 1);
                runLen = end - start;
            }
            start += runLen;
        }

        // Merge runs
        for (int size = minRun; size < n; size *= 2) {
            for (int left = 0; left < n; left += 2 * size) {
                int mid = left + size - 1;
                int right = Math.min((left + 2 * size - 1), (n - 1));
                if (mid < right) {
                    merge(arr, left, mid, right);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 21, 7, 23, 19, 11, 9, 3, 15, -1};
        timSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

// Time Complexity

//Best:    O(n)
//Average: O(n log n)
//Worst:   O(n log n)