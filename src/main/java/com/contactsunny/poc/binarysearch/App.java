package com.contactsunny.poc.binarysearch;

public class App {

    public static void main(String[] args) {
        int[] array = {2, 10, 13, 14, 29, 37, 100};
        printArray(array);
        System.out.println("-------------------------");

        int numberToFind = 37;
        int index = searchInArray(array, numberToFind);
        if (index == -1) {
            System.out.println(numberToFind + " not found in the array!");
        } else {
            System.out.println(numberToFind + " found at index " + index);
        }

    }

    private static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    /**
     * Method to start the recursive algorithm to perform binary search on the array to find the element
     *
     * @param array the given sorted array
     * @param numberToFind the number to find
     * @return the index of the number to find.
     */
    private static int searchInArray(int[] array, int numberToFind) {
        // Initializing the first iteration of the recursive search
        return performBinarySearch(array, numberToFind, 0, array.length - 1);
    }

    /**
     * Binary search method to find the element in the given sorted array recursively.
     *
     * @param array The given sorted array
     * @param numberToFind Tthe number to find
     * @param left The left index
     * @param right The right index
     * @return The index at which the element was found.
     */
    private static int performBinarySearch(int[] array, int numberToFind, int left, int right) {
        // Checking if we have crossed the boundaries
        if (right >= left) {
            // The middle element.
            int mid = left + (right - left) / 2;
            // If we find the element at array[mid], we're done with the search
            if (array[mid] == numberToFind) {
                return mid;
            }
            // If the number to find is less than the value at the mid index,
            // we have to continue the search in the left sub-array.
            // Calling the search method again with the left and right bounds for the left sub-array
            if (numberToFind < array[mid]) {
                return performBinarySearch(array, numberToFind, left, mid - 1);
            }
            // If the number to find is greater than the value at the mid index,
            // we have to continue the search in the right sub-array.
            // Calling the search method again with the left and right bounds for the right sub-array
            return performBinarySearch(array, numberToFind, mid + 1, right);
        }
        // We reach this statement when we have iterated throughout the array and haven't yet found the element.
        // A value of -1 will indicate that the element wasn't found.
        return -1;
    }
}
