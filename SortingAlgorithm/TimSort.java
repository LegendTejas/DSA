package SortingAlgorithm;

public class TimSort {
    private static final int MIN_RUN = 32; // Minimum run size for TimSort

    // Calculate the minimum run length
    private static int minRunLength(int n) {
        int r = 0;
        while (n >= MIN_RUN) {
            r |= (n & 1);
            n >>= 1;
        }
        return n + r;
    }

    // Insertion sort for small parts (runs)
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

    // Merge two sorted subarrays
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

        // Sort small runs using insertion sort
        for (int i = 0; i < n; i += minRun) {
            insertionSort(arr, i, Math.min(i + minRun - 1, n - 1));
        }

        // Merge runs in size powers of two
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
        int[] arr = {5, 21, 7, 23, 19, -11, 9, 3, 15, -2};
        timSort(arr);
        
        for(int num : arr) {
        	System.out.print(num+" ");
        }
        System.out.println();
    }
    
}

//Time complexity

//Best:    O(n)
//Average: O(n log n)
//Worst:   O(n log n)