package SortingAlgorithm;

public class InsertionSort {

    public static void main(String[] args) {
        // Initialize the array to be sorted
        int arr[] = {9, 4, 2, 7, 8, 1};

        // We assume the first element is already "sorted"
        // Start iterating from the second element (index 1)
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i]; // Store the current value to be inserted
            int j = i - 1; // Start comparing with elements to the left of current

            // Shift elements of the sorted part that are greater than current to the right
            while (j >= 0 && current < arr[j]) {
                arr[j + 1] = arr[j]; // Shift element one position to the right
                j--; // Move one step left
            }

            // Place the current value into its correct position
            arr[j + 1] = current;
        }

        // Print the sorted array
        System.out.print("Sorted Array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}