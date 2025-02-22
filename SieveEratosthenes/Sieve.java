package SieveEratosthenes;

import java.util.ArrayList;

public class Sieve {

    /*
     * Sieve of Eratosthenes algorithm to find all prime numbers up to a given
     * limit.
     * Time Complexity: O(n log(log n)), Space Complexity: O(n)
     */
    public static void sieveOfEratosthenese(int limit) {
        // Create a boolean array to track prime numbers
        // output[x] will be true if x is a prime number
        boolean output[] = new boolean[limit + 1];

        // Initialize the output array to true (assume all numbers are prime
        // initially)
        for (int x = 0; x <= limit; x++) {
            output[x] = true;
        }

        // 0 and 1 are not prime numbers
        output[0] = false;
        output[1] = false;

        // SApply the Sieve of Eratosthenes algorithm
        for (int i = 2; i <= limit; i++) {
            // If i is a prime number, mark all its multiples as non-prime
            if (output[i]) {
                // Start from i^2 and mark all multiples of i as false (non-prime)
                for (int j = (int) Math.pow(i, 2); j <= limit; j += i) {
                    output[j] = false;
                }
            }
        }

        // Collect all prime numbers into an ArrayList
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < output.length; i++) {
            if (output[i]) {
                result.add(i);
            }
        }

        // Print the results in a formatted way
        System.out.println("Prime numbers up to " + limit + ":\n");

        // (Formatting for cleanliness in output) Print 3 rows of 10 elements for large
        // datasets
        if (result.size() > 30) {
            for (int row = 0; row < 3; row++) {
                System.out.print("  ");
                for (int i = row * 10; i < (row + 1) * 10; i++) {
                    System.out.printf("%3d", result.get(i)); // Format each number to 5 spaces
                    if (i < (row + 1) * 10 - 1) {
                        System.out.print(", ");
                    }
                }
                System.out.println();
            }
            System.out.println("  [...]"); // Indicate there are more primes
        } else {
            // Print all primes for small datasets
            System.out.print("  ");
            for (int i = 0; i < result.size(); i++) {
                System.out.printf("%3d", result.get(i)); // Format each number to 5 spaces
                if (i < result.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }

        System.out.println("\nTotal primes found: " + result.size());
        System.out.println();
    }

    /*
     * Main method to demonstrate the functionality of the Sieve class.
     */
    public static void main(String[] args) {
        // Small dataset
        int smallLimit = 30;
        System.out.println("-----------------------------------------");
        System.out.println("Small Set: Limit = " + smallLimit);
        System.out.println("-----------------------------------------");

        // Measure runtime for small dataset
        long startTimeSmall = System.nanoTime();
        sieveOfEratosthenese(smallLimit);
        long endTimeSmall = System.nanoTime();
        double runtimeSmall = endTimeSmall - startTimeSmall;
        System.out.println("Runtime: " + runtimeSmall + " nanoseconds");
        System.out.println();

        // Large dataset
        int largeLimit = 1_000_000; // 1 million
        System.out.println("-----------------------------------------");
        System.out.println("Large Set: Limit = " + largeLimit);
        System.out.println("-----------------------------------------");

        // Measure runtime for large dataset
        long startTimeLarge = System.nanoTime();
        sieveOfEratosthenese(largeLimit);
        long endTimeLarge = System.nanoTime();
        double runtimeLarge = endTimeLarge - startTimeLarge;
        System.out.println("Runtime: " + runtimeLarge + " nanoseconds");
        System.out.println();
    }
}