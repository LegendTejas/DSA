package SortingAlgorithm;

//Time Complexity: O(d.(n+k)) or simply O(d.n)

//n = number of elements in the array
//d = number of digits in the largest number
//k = range of each digit (for decimal, k=10)

public class RadixSort {

    // Function to get the maximum value in the array
    static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    // Counting sort based on a specific digit (place)
    static void countingSort(int[] arr, int place) {
        int n = arr.length;
        int[] output = new int[n]; // output array
        int[] count = new int[10]; // for digits 0-9

        // Store the count of occurrences
        for (int i = 0; i < n; i++) {
            int digit = (arr[i] / place) % 10;
            count[digit]++;
        }

        // Change count[i] so it contains actual position of this digit in output[]
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1]; //cumulative count (convert to prefix sum)
        }

        // Build the output array (traverse arr in reverse for stability)
        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / place) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        // Copy the output array back to arr[]
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

    // Radix sort main function
    static void radixSort(int[] arr) {
        int max = getMax(arr); // Find the maximum number to know the number of digits

        // Apply counting sort to each digit (place = 1, 10, 100, ...)
        for (int place = 1; max / place > 0; place *= 10) {
            countingSort(arr, place);
        }
    }

    public static void main(String[] args) {
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        radixSort(arr);
        
        for(int num: arr) {
            System.out.print(num+" ");
        }
        System.out.println();
    }
}
