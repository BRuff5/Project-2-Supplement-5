import java.util.HashSet;
import java.util.Set;

/**
 * This class contains three functionalities:
 * 1. A static method determining if a 2D matrix is a magic square.
 * 2. A method to count the number of unique subarrays that sum to a given value.
 * 3. A method to find the longest palindromic substring in a given string.
 */

 public class main {

    /**
     * Check if the 2D matrix is a magic square.
     *
     * @param matrix the 2D array 
     * @return if the magic square
     */
    public static boolean isMagicSquare(int[][] matrix) {
        int n = matrix.length;
        int magicSum = 0;

        // Calculating the magic sum 
        for (int j = 0; j < n; j++) {
            magicSum += matrix[0][j];
        }

        // Checking sum of rows
        for (int i = 1; i < n; i++) {
            int rowSum = 0;
            for (int j = 0; j < n; j++) {
                rowSum += matrix[i][j];
            }
            if (rowSum != magicSum) {
                return false;
            }
        }

        // Checking sum of columns
        for (int j = 0; j < n; j++) {
            int colSum = 0;
            for (int i = 0; i < n; i++) {
                colSum += matrix[i][j];
            }
            if (colSum != magicSum) {
                return false;
            }
        }

        // Checking main 
        int diagonal1Sum = 0;
        for (int i = 0; i < n; i++) {
            diagonal1Sum += matrix[i][i];
        }
        if (diagonal1Sum != magicSum) {
            return false;
        }

        // Checking secondary 
        int diagonal2Sum = 0;
        for (int i = 0; i < n; i++) {
            diagonal2Sum += matrix[i][n - 1 - i];
        }
        return diagonal2Sum == magicSum;
    }

    /**
     * Counts the number of subarrays  
     *
     * @param nums   the input integer array
     * @param target the target sum
     * @return the number of subarray
     */
    public static int countUniqueSubarrays(int[] nums, int target) {
        Set<String> uniqueSubarrays = new HashSet<>();
        // Starting points
        for (int start = 0; start < nums.length; start++) {
            int sum = 0;
            StringBuilder subarray = new StringBuilder();
            // ending points
            for (int end = start; end < nums.length; end++) {
                sum += nums[end];
                subarray.append(nums[end]).append(",");
                // Seeif sum equals
                if (sum == target) {
                    uniqueSubarrays.add(subarray.toString());
                }
            }
        }
        return uniqueSubarrays.size(); // Return the count 
    }
    

    /**
     * Finds the longest palindromic substring in a given string.
     *
     * @param s the input string
     * @return the longest palindromic substring
     */
    public static String longestPalindrome(String s) {
        int n = s.length();
        if (n == 0) return "";

        boolean[][] dp = new boolean[n][n]; //Track palindromic substrings
        String longest = "";

        
        for (int end = 0; end < n; end++) {
            for (int start = 0; start <= end; start++) {
                if (s.charAt(start) == s.charAt(end) && (end - start <= 2 || dp[start + 1][end - 1])) {
                    dp[start][end] = true;

                    // Update 
                    if (end - start + 1 > longest.length()) {
                        longest = s.substring(start, end + 1);
                    }
                }
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        // Test for magic square
        int[][] matrix = {
            { 4, 9, 2 },
            { 3, 5, 7 },
            { 8, 1, 6 }
        };
        System.out.println("Is magic square: " + isMagicSquare(matrix));

        // Subrays
        int[] nums = {1, 2, 1, 2, 3};
        int target = 3;
        System.out.println("Number of unique subarrays with sum " + target + ": " + countUniqueSubarrays(nums, target));

        //Longest palindromic substring
        String str = "babad";
        System.out.println("Longest palindromic substring: " + longestPalindrome(str));
    }
}

 