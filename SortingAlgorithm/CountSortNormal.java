package SortingAlgorithm;

// this code works only for non-negative integers

// Time Complexity: O(n+k) where k = max + 1 = size of count array

public class CountSortNormal {

    // Returns the maximum value in the array
    static int findMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    // Basic Counting Sort (not stable)
    public static void basicCountSort(int[] arr) {
        if (arr.length == 0) return;

        int max = findMax(arr);
        int[] count = new int[max + 1];

        // Count occurrences
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

        // Fill original array with sorted elements
        int k = 0;
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                arr[k++] = i;
            }
        }
    }

    // Stable Counting Sort
    public static void countSort(int[] arr) {
        if (arr.length == 0) return;

        int n = arr.length;
        int max = findMax(arr);
        int[] count = new int[max + 1];
        int[] output = new int[n];

        // Count occurrences
        for (int i = 0; i < n; i++) {
            count[arr[i]]++;
        }

        // Prefix sum
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        // Build output array (stable sort)
        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }

        // Copy output to original array
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 5, 2, 2, 5};

        countSort(arr);

        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}