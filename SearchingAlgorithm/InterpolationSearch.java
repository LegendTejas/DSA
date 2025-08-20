// Improvement over Binary Search 
// Formula we use:  int pos = left + ((target - arr[left]) * (right - left)) / (arr[right] - arr[left]);

public class InterpolationSearch {

    // Interpolation search function: returns index of target if found, else -1
    public static int interpolationSearch(int[] arr, int target) {
        int left = 0;                  // Start of the search range
        int right = arr.length - 1;    // End of the search range

        while (left <= right && target >= arr[left] && target <= arr[right]) {
            // Estimate the position of the target using interpolation formula
            int pos = left + ((target - arr[left]) * (right - left)) 
                        / (arr[right] - arr[left]);

            // Check if the element at pos is the target
            if (arr[pos] == target) {
                return pos; // Target found
            }

            // If target is larger, move search to the right part
            if (arr[pos] < target) {
                left = pos + 1;
            }
            // If target is smaller, move search to the left part
            else {
                right = pos - 1;
            }
        }

        // Target not found in the array
        return -1;
    }

    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50, 60, 70}; // Sorted and evenly distributed
        int target = 40; // Number we want to find

        int result = interpolationSearch(numbers, target);

        if (result != -1) {
            System.out.println("Target " + target + " found at index: " + result);
        } else {
            System.out.println("Target " + target + " not found in the array.");
        }
    }
}
