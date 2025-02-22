package Knapsack;

/* Date: 2/21/2025
 * Problem Name: Knapsack Problem
 * Problem description: Given a set of items, each with a weight and a value, determine the maximum value 
 *                     that can be obtained by selecting a subset of the items without exceeding a given 
 *                     weight limit.
 * Author: @JGriff1995
 * Link: N/A - codeacademy
 */

public class KnapsackSolution {

    /*
     * Dynamic Programming Solution for the Knapsack Problem.
     * Time Complexity: O(n * W), where n = number of items, W = weight capacity.
     * Space Complexity: O(n * W) for the 2D matrix.
     */
    public static int dynamicSolution(int weightCap, int[] weights, int[] values, int item) {
        int index, weight;
        int[][] matrix = new int[item + 1][weightCap + 1]; // Create a 2D matrix to store subproblem results

        // Fill the matrix
        for (index = 0; index <= item; index++) {
            for (weight = 0; weight <= weightCap; weight++) {
                if (index == 0 || weight == 0) {
                    // Base case: If no items or no capacity, value is 0
                    matrix[index][weight] = 0;
                } else if (weights[index - 1] <= weight) {
                    // If the current item's weight is within the capacity
                    int includeValue = values[index - 1] + matrix[index - 1][weight - weights[index - 1]]; // Include
                                                                                                           // the item
                    int excludeValue = matrix[index - 1][weight]; // Exclude the item
                    matrix[index][weight] = Math.max(includeValue, excludeValue); // Choose the maximum value
                } else {
                    // If the current item's weight exceeds the capacity, exclude it
                    matrix[index][weight] = matrix[index - 1][weight]; // Copy value from the cell above
                }
            }
        }
        return matrix[item][weightCap]; // Return the maximum value
    }

    /*
     * Recursive Solution for the Knapsack Problem.
     * Time Complexity: O(2^n), where n = number of items (exponential due to
     * overlapping subproblems).
     * Space Complexity: O(n) for the recursion stack.
     */
    public static int recursiveSolution(int weightCap, int[] weights, int[] values, int item) {
        // Base case: If no items or no capacity, value is 0
        if (item == 0 || weightCap == 0) {
            return 0;
        }

        // If the current item's weight exceeds the capacity, exclude it
        if (weights[item - 1] > weightCap) {
            return recursiveSolution(weightCap, weights, values, item - 1);
        }

        // Return the maximum of including or excluding the current item
        int includeValue = values[item - 1]
                + recursiveSolution(weightCap - weights[item - 1], weights, values, item - 1); // Include the item
        int excludeValue = recursiveSolution(weightCap, weights, values, item - 1); // Exclude the item
        return Math.max(includeValue, excludeValue); // Choose the maximum value
    }

    /*
     * Main method to demonstrate the functionality of the Knapsack class.
     */
    public static void main(String[] args) {
        // Small dataset
        int smallValues[] = new int[] { 70, 20, 39, 37, 7, 5, 10 };
        int smallWeights[] = new int[] { 31, 10, 20, 19, 4, 3, 6 };
        int smallWeightCap = 50;
        int smallItemCount = smallValues.length;

        // Measure runtime for dynamic programming solution (small dataset)
        long startTimeDynamicSmall = System.nanoTime();
        int dynamicResultSmall = dynamicSolution(smallWeightCap, smallWeights, smallValues, smallItemCount);
        long endTimeDynamicSmall = System.nanoTime();
        long runtimeDynamicSmall = endTimeDynamicSmall - startTimeDynamicSmall;

        // Measure runtime for recursive solution (small dataset)
        long startTimeRecursiveSmall = System.nanoTime();
        int recursiveResultSmall = recursiveSolution(smallWeightCap, smallWeights, smallValues, smallItemCount);
        long endTimeRecursiveSmall = System.nanoTime();
        long runtimeRecursiveSmall = endTimeRecursiveSmall - startTimeRecursiveSmall;

        // Print results for small dataset
        System.out.println("-----------------------------------------");
        System.out.println("Knapsack Problem Results: Small Set");
        System.out.println("-----------------------------------------");
        System.out.println("Dynamic Programming Solution: $" + dynamicResultSmall);
        System.out.println("  - Time Complexity: O(n * W), where n = number of items, W = weight capacity");
        System.out.println("  - Space Complexity: O(n * W)");
        System.out.println("  - Runtime: " + runtimeDynamicSmall + " nanoseconds");
        System.out.println();
        System.out.println("Recursive Solution: $" + recursiveResultSmall);
        System.out.println("  - Time Complexity: O(2^n), where n = number of items");
        System.out.println("  - Space Complexity: O(n) for the recursion stack");
        System.out.println("  - Runtime: " + runtimeRecursiveSmall + " nanoseconds");
        System.out.println("-----------------------------------------");

        // Very large dataset
        int largeValues[] = new int[] { 60, 100, 120, 80, 30, 50, 70, 90, 110, 40, 130, 150, 170, 200, 250, 300, 350,
                400, 450, 500 };
        int largeWeights[] = new int[] { 10, 20, 30, 15, 5, 25, 35, 40, 45, 12, 50, 55, 60, 65, 70, 75, 80, 85, 90,
                95 };
        int largeWeightCap = 500;
        int largeItemCount = largeValues.length;

        // Measure runtime for dynamic programming solution (large dataset)
        long startTimeDynamicLarge = System.nanoTime();
        int dynamicResultLarge = dynamicSolution(largeWeightCap, largeWeights, largeValues, largeItemCount);
        long endTimeDynamicLarge = System.nanoTime();
        long runtimeDynamicLarge = endTimeDynamicLarge - startTimeDynamicLarge;

        // Measure runtime for recursive solution (large dataset)
        long startTimeRecursiveLarge = System.nanoTime();
        int recursiveResultLarge = recursiveSolution(largeWeightCap, largeWeights, largeValues, largeItemCount);
        long endTimeRecursiveLarge = System.nanoTime();
        long runtimeRecursiveLarge = endTimeRecursiveLarge - startTimeRecursiveLarge;

        // Print results for large dataset
        System.out.println("-----------------------------------------");
        System.out.println("Knapsack Problem Results: Very Large Set");
        System.out.println("-----------------------------------------");
        System.out.println("Dynamic Programming Solution: $" + dynamicResultLarge);
        System.out.println("  - Time Complexity: O(n * W), where n = number of items, W = weight capacity");
        System.out.println("  - Space Complexity: O(n * W)");
        System.out.println("  - Runtime: " + runtimeDynamicLarge + " nanoseconds");
        System.out.println();
        System.out.println("Recursive Solution: $" + recursiveResultLarge);
        System.out.println("  - Time Complexity: O(2^n), where n = number of items");
        System.out.println("  - Space Complexity: O(n) for the recursion stack");
        System.out.println("  - Runtime: " + runtimeRecursiveLarge + " nanoseconds");
        System.out.println("-----------------------------------------");
    }
}