package JumpGame1;

/* Date: 
 * Problem Name: 
 * Problem description: 
 * Author: @insert_name 
 * Link: https://leetcode.com/problems/jump-game/description/
 */

public class JumpGameSolution {

    /*
     * Can Jump method
     * Determines if the last index of the array is reachable.
     * Time Complexity: O(n), where n is the length of the array.
     * Space Complexity: O(1), as we use only a few variables.
     */
    public static boolean canJump(int[] nums) {
        int length = nums.length;
        int farthest = 0; // Tracks the farthest index we can reach

        // Edge case: If array has length of 1, we're already at the last index
        if (length == 1) {
            return true;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            // If current index is beyond the farthest we can reach, return false
            if (i > farthest) {
                return false;
            }
            // Update the farthest index we can reach
            farthest = Math.max(farthest, i + nums[i]);

            // If we can reach or go beyond the last index, return true
            if (farthest >= length - 1) {
                return true;
            }
        }

        // If we finish the loop without reaching the end, return false
        return false;
    }

    /*
     * Main method to demonstrate the functionality of the class.
     */
    public static void main(String[] args) {
        // Input 1: Can reach the last index
        int[] input1 = { 2, 3, 1, 1, 4 };
        System.out.println("Input 1: [2, 3, 1, 1, 4]");
        System.out.println("Can reach the last index? " + canJump(input1)); // Expected: true
        System.out.println("Time Complexity: O(n), Space Complexity: O(1)");
        System.out.println();

        // Input 2: Cannot reach the last index
        int[] input2 = { 3, 2, 1, 0, 4 };
        System.out.println("Input 2: [3, 2, 1, 0, 4]");
        System.out.println("Can reach the last index? " + canJump(input2)); // Expected: false
        System.out.println("Time Complexity: O(n), Space Complexity: O(1)\n");

        // Input 3: Single-element array (already at the last index)
        int[] input3 = { 0 };
        System.out.println("Input 3: [0]");
        System.out.println("Can reach the last index? " + canJump(input3)); // Expected: true
        System.out.println("Time Complexity: O(n), Space Complexity: O(1)");
    }
}