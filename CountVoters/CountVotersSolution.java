package CountVoters;

import java.util.HashMap;
import java.util.Map;

/* Date: 2/21/2025
 * Problem Name: Find Winner of an Election where votes are candidate Names
 * Problem description: Given an array of names of candidates in an election. A candidate’s name in the array 
 * represents a vote cast on the candidate. Print the name of candidates who received the maximum vote. If 
 * there is a tie, print a lexicographically smaller name.
 * Author: @Jgriff1995
 * Link: https://www.geeksforgeeks.org/find-winner-election-votes-represented-candidate-names/
 */

public class CountVotersSolution {

    /*
     * Solution 1: Standard Array
     * Time Complexity: O(n^2), Space Complexity: O(1)
     * Explanation: For each candidate, we count their votes by iterating through
     * the entire array.
     * This results in a nested loop, leading to O(n^2) time complexity.
     */
    public static String findWinnerOne(String[] input) {
        int prevVoteCount = 0;
        String winner = "";

        for (int i = 0; i < input.length; i++) {
            int voteCount = 0;

            for (int j = 0; j < input.length; j++) {
                if (input[i].equals(input[j])) {
                    voteCount++;
                }
            }

            if (voteCount > prevVoteCount) {
                prevVoteCount = voteCount;
                winner = input[i];
            } else if (voteCount == prevVoteCount) {
                if (input[i].compareTo(winner) < 0) {
                    winner = input[i];
                }
            }
        }

        return winner;
    }

    /*
     * Solution 2: Hashing
     * Time Complexity: O(n), Space Complexity: O(n)
     * Explanation: We use a HashMap to store the vote count for each candidate.
     * This allows us to count votes in O(n) time and determine the winner
     * efficiently.
     */
    public static String findWinnerTwo(String[] input) {
        // Create a HashMap to hold the key-value pairs: <name, voteCount>
        Map<String, Integer> votes = new HashMap<>();
        int maxVoteCount = 0;
        String winner = "";

        // Populate the map with candidate names and their vote counts
        for (String name : input) {
            votes.put(name, votes.getOrDefault(name, 0) + 1);
        }

        // Iterate over the map to find the candidate with the maximum votes
        for (Map.Entry<String, Integer> entry : votes.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            if (value > maxVoteCount) {
                maxVoteCount = value;
                winner = key;
            } else if (value == maxVoteCount && winner.compareTo(key) > 0) {
                winner = key;
            }
        }

        return winner;
    }

    /*
     * Helper method to print the voting pool and results in a visually appealing
     * format.
     */
    public static void printResults(String[] votes, String winner, String methodName, long runtime) {
        System.out.println("Voting Pool:");
        Map<String, Integer> voteCount = new HashMap<>();
        for (String name : votes) {
            voteCount.put(name, voteCount.getOrDefault(name, 0) + 1);
        }

        // Print the voting pool with vote counts
        for (Map.Entry<String, Integer> entry : voteCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votes");
        }

        // Print the winner and runtime
        System.out.println("\nWinner: " + winner);
        System.out.println("Method: " + methodName);
        System.out.println("Runtime: " + runtime + " nanoseconds");
        System.out.println("\n" + "=".repeat(50) + "\n");
    }

    /*
     * Main method to demonstrate the functionality of the class.
     */
    public static void main(String[] args) {
        // Test Case 1
        String[] votes1 = { "john", "johnny", "jackie", "johnny", "john", "jackie", "jamie", "jamie", "john", "johnny",
                "jamie", "johnny", "john" };

        // Test Case 2
        String[] votes2 = { "virat", "rohit", "rishabh", "rohit", "virat", "rohit" };

        // Test Case 3 (Tie Scenario)
        String[] votes3 = { "alice", "bob", "alice", "bob", "charlie", "charlie", "charlie" };

        // Test Case 4 (Single Candidate)
        String[] votes4 = { "sarah", "sarah", "sarah" };

        // Test Case 5 (All Unique Candidates)
        String[] votes5 = { "dave", "emma", "frank", "grace" };

        // Run Solution 1 (Standard Array)
        long startTime = System.nanoTime();
        String winner1 = findWinnerOne(votes1);
        long endTime = System.nanoTime();
        printResults(votes1, winner1, "Standard Array", endTime - startTime);

        startTime = System.nanoTime();
        String winner2 = findWinnerOne(votes2);
        endTime = System.nanoTime();
        printResults(votes2, winner2, "Standard Array", endTime - startTime);

        // Run Solution 2 (Hashing)
        startTime = System.nanoTime();
        String winner3 = findWinnerTwo(votes1);
        endTime = System.nanoTime();
        printResults(votes1, winner3, "Hashing", endTime - startTime);

        startTime = System.nanoTime();
        String winner4 = findWinnerTwo(votes2);
        endTime = System.nanoTime();
        printResults(votes2, winner4, "Hashing", endTime - startTime);

        // Additional Test Cases
        startTime = System.nanoTime();
        String winner5 = findWinnerTwo(votes3);
        endTime = System.nanoTime();
        printResults(votes3, winner5, "Hashing", endTime - startTime);

        startTime = System.nanoTime();
        String winner6 = findWinnerTwo(votes4);
        endTime = System.nanoTime();
        printResults(votes4, winner6, "Hashing", endTime - startTime);

        startTime = System.nanoTime();
        String winner7 = findWinnerTwo(votes5);
        endTime = System.nanoTime();
        printResults(votes5, winner7, "Hashing", endTime - startTime);
    }
}