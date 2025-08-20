public class BinarySearch {

    // Binary search function: returns index of target if found, else -1
    public static int binarySearch(int[] arr, int target) {
        int left = 0;                  // Start of the search range
        int right = arr.length - 1;    // End of the search range

        while (left <= right) {
            // Calculate the middle index (avoid overflow)
            int mid = left + (right - left) / 2;

            // Check if the middle element is the target
            if (arr[mid] == target) {
                return mid; // Target found
            }
            // If target is greater, ignore left half
            else if (arr[mid] < target) {
                left = mid + 1;
            }
            // If target is smaller, ignore right half
            else {
                right = mid - 1;
            }
        }

        // Target not found in the array
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 9, 11, 13}; // Sorted array
        int target = 7; // Number we want to find

        int result = binarySearch(nums, target);

        if (result != -1) {
            System.out.println("Target " + target + " found at index: " + result);
        } else {
            System.out.println("Target " + target + " not found in the array.");
        }
    }
}
