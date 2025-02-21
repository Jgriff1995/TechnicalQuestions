package Rainwater;

public class Rainwater {

    /*
     * Naive solution to calculate trapped rainwater.
     * Time Complexity: O(N^2), Space Complexity: O(1)
     */
    public static int naiveSolution(int[] heights) {
        // Initialize Empty water variable
        int totalWater = 0;

        // Iterate over the length of heights
        for (int i = 0; i < heights.length - 1; i++) {
            int leftBound = 0;
            int rightBound = 0;

            // Find highest Left bound
            for (int j = 0; j <= i; j++) {
                leftBound = Math.max(leftBound, heights[j]);
            }

            // Find highest Right bound
            for (int k = i; k < heights.length; k++) {
                rightBound = Math.max(rightBound, heights[k]);
            }

            // Take Lower (Math.min) of both values, and subtract the current index from
            // that value
            // add to the total amount of water captured
            totalWater += Math.min(leftBound, rightBound) - heights[i];
        }
        // return totalwater
        return totalWater;
    }

    /*
     * Optimized solution to calculate trapped rainwater using two pointers.
     * Time Complexity: O(N), Space Complexity: O(1)
     */
    public static int optimizedSolution(int[] heights) {
        int totalWater = 0, leftPointer = 0, rightPointer = heights.length - 1, leftBound = 0, rightBound = 0;

        // iterate over until the pointers meet
        while (leftPointer < rightPointer) {
            // If the left bar is smaller or equal to the right bar
            if (heights[leftPointer] <= heights[rightPointer]) {
                // Update the left bound if the current bar is taller
                leftBound = Math.max(heights[leftPointer], leftBound);
                // Add the trapped water at the current position
                totalWater += leftBound - heights[leftPointer];
                // Move the left pointer to the right
                leftPointer++;
            } else {
                // Update the right bound if the current bar is taller
                rightBound = Math.max(heights[rightPointer], rightBound);
                // Add the trapped water at the current position
                totalWater += rightBound - heights[rightPointer];
                // Move the right pointer to the left
                rightPointer--;
            }
        }

        return totalWater;
    }

    /*
     * Prints a histogram of the given data array.
     */
    public static void printHistogram(int[] data) {
        int maxValue = getMaxValue(data);

        // Print y-axis and histogram bars
        for (int i = maxValue; i >= 0; i--) {
            System.out.printf("%2d | ", i); // y-axis labels
            for (int value : data) {
                if (value >= i) {
                    System.out.print("| ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

        // Print x-axis line
        System.out.print("   +");
        for (int i = 0; i < data.length; i++) {
            System.out.print("--");
        }
        System.out.println();

        // Print x-axis labels (original array values)
        System.out.print("     ");
        for (int value : data) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    /*
     * Prints a histogram of the given data array with trapped rainwater represented
     * by 'x'.
     */
    public static void printAlteredHistogram(int[] data) {
        int maxValue = getMaxValue(data);

        // Calculate trapped rainwater
        int[] leftMax = new int[data.length];
        int[] rightMax = new int[data.length];
        int[] water = new int[data.length];

        // Left max array
        leftMax[0] = data[0];
        for (int i = 1; i < data.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], data[i]);
        }

        // Right max array
        rightMax[data.length - 1] = data[data.length - 1];
        for (int i = data.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], data[i]);
        }

        // Calculate trapped water
        for (int i = 0; i < data.length; i++) {
            water[i] = Math.min(leftMax[i], rightMax[i]) - data[i];
        }

        // Print y-axis and histogram bars
        for (int i = maxValue; i >= 0; i--) {
            System.out.printf("%2d | ", i); // y-axis labels
            for (int j = 0; j < data.length; j++) {
                if (data[j] >= i) {
                    System.out.print("| ");
                } else if (i <= data[j] + water[j]) {
                    System.out.print("x ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

        // Print x-axis line
        System.out.print("   +");
        for (int i = 0; i < data.length; i++) {
            System.out.print("--");
        }
        System.out.println();

        // Print x-axis labels (original array values)
        System.out.print("     ");
        for (int value : data) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    /*
     * Helper function to find the maximum value in the data array.
     */
    private static int getMaxValue(int[] data) {
        int max = data[0];
        for (int value : data) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    /*
     * Main method to demonstrate the functionality of the Rainwater class.
     */
    public static void main(String[] args) {
        // Show as histogram
        System.out.println("Naive approach: ----------------\n");
        int[] testArray = { 4, 2, 1, 3, 0, 1, 2 };
        System.out.println("Original Histogram: \n");
        printHistogram(testArray);
        System.out.println("\nHistogram after Rain Fall: \n");
        printAlteredHistogram(testArray);
        System.out.println("\nTotal water contained after rain in Histogram: " + naiveSolution(testArray) + "\n");
        System.out.println("Time complexity: O(N^2)");
        System.out.println("Space Complexity: O(1)\n");

        // Show as histogram
        System.out.println("Optimized approach: ----------------\n");
        System.out.println("Original Histogram: \n");
        printHistogram(testArray);
        System.out.println("\nHistogram after Rain Fall: \n");
        printAlteredHistogram(testArray);
        System.out.println("\nTotal water contained after rain in Histogram: " + optimizedSolution(testArray));
        System.out.println("Time complexity: O(N)");
        System.out.println("Space Complexity: O(1)");
    }
}