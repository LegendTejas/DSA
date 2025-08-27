// This program demonstrates all the major operations on arrays in Java.
import java.util.Arrays;

public class ArraysDemo {

    public static void main(String[] args) {

        // 1. Array Declaration & Initialization
        int[] arr = {10, 20, 30, 40, 50};
        System.out.println("Original Array: " + Arrays.toString(arr));

        // 2. Accessing Elements (O(1))
        System.out.println("Element at index 2: " + arr[2]);

        // 3. Traversing an Array
        System.out.print("Traversing using for loop: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        System.out.print("Traversing using for-each loop: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        // 4. Insertion at a Specific Index (O(n))
        int[] newArr = new int[arr.length + 1];
        int insertIndex = 2;
        int insertValue = 99;

        for (int i = 0, j = 0; i < newArr.length; i++) {
            if (i == insertIndex) {
                newArr[i] = insertValue;
            } else {
                newArr[i] = arr[j++];
            }
        }
        System.out.println("After inserting 99 at index 2: " + Arrays.toString(newArr));

        // 5. Deletion from a Specific Index (O(n))
        int deleteIndex = 3;
        int[] smallerArr = new int[newArr.length - 1];
        for (int i = 0, j = 0; i < newArr.length; i++) {
            if (i != deleteIndex) {
                smallerArr[j++] = newArr[i];
            }
        }
        System.out.println("After deleting element at index 3: " + Arrays.toString(smallerArr));

        // 6. Searching an Element (Linear Search, O(n))
        int searchValue = 30;
        boolean found = false;
        for (int i = 0; i < smallerArr.length; i++) {
            if (smallerArr[i] == searchValue) {
                System.out.println("Element " + searchValue + " found at index " + i);
                found = true;
                break;
            }
        }
        if (!found) System.out.println("Element " + searchValue + " not found");

        // 7. Sorting an Array (O(n log n))
        Arrays.sort(smallerArr);
        System.out.println("After sorting: " + Arrays.toString(smallerArr));

        // 8. Copying Arrays
        int[] copyArr = Arrays.copyOf(smallerArr, smallerArr.length);
        System.out.println("Copied Array: " + Arrays.toString(copyArr));

        // 9. Multi-Dimensional Arrays
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println("2D Array (Matrix):");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        // 10. Using Utility Methods
        System.out.println("Does array contain 20? " + contains(copyArr, 20));
        System.out.println("Max element in array: " + findMax(copyArr));
        System.out.println("Min element in array: " + findMin(copyArr));
    }

    // Helper Method: Check if array contains a value
    public static boolean contains(int[] arr, int value) {
        for (int num : arr) {
            if (num == value) return true;
        }
        return false;
    }

    // Helper Method: Find Maximum
    public static int findMax(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max) max = num;
        }
        return max;
    }

    // Helper Method: Find Minimum
    public static int findMin(int[] arr) {
        int min = arr[0];
        for (int num : arr) {
            if (num < min) min = num;
        }
        return min;
    }
}