package SortingAlgorithm;

// optimized and stable version of Counting Sort that supports negative integers

// Time Complexity: O(n+k) where k = range of input values = max - min + 1

public class CountSortOptimized {

    // Find minimum value in the array
    static int findMin(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int num : arr) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    // Find maximum value in the array
    static int findMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    // Counting Sort that supports negative numbers
    public static void countSort(int[] arr) {
        if (arr.length == 0) return;

        int min = findMin(arr);
        int max = findMax(arr);

        int range = max - min + 1;
        int[] count = new int[range];
        int[] output = new int[arr.length];

        // Count occurrences, shifting by -min to handle negatives
        for (int num : arr) {
            count[num - min]++;
        }

        // Prefix sum for stable sort
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        // Build output array
        for (int i = arr.length - 1; i >= 0; i--) {
            int num = arr[i];
            output[count[num - min] - 1] = num;
            count[num - min]--;
        }

        // Copy sorted array back
        System.arraycopy(output, 0, arr, 0, arr.length);
    }

    public static void main(String[] args) {
        int[] arr = {4, -1, 0, -2, 3, -1, 0, 2};

        countSort(arr);

        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}