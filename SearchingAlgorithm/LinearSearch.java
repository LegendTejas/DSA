public class LinearSearch {

    public static int linearSearch(int[] arr, int target) {
        // Go through each element in the array one by one
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        // Target not found in the array
        return -1;
    }

    public static void main(String[] args) {
        int[] numbers = {12, 34, 56, 78, 90}; // Array (can be unsorted)
        int target = 56; // Number we want to find

        int result = linearSearch(numbers, target);

        if (result != -1) {
            System.out.println("Target " + target + " found at index: " + result);
        } else {
            System.out.println("Target " + target + " not found in the array.");
        }
    }
}
