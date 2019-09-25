/*
 * Copyright 2019, FMR LLC.
 * All Rights Reserved
 * Fidelity Confidential Information
 */

public class FibonacciMemoization {
    private static int[] memo = new int[1000];
    /*
        Time complexity before memoization - O(2^n)
        Time complexity after memoization - O(n)
     */
    static int fib(int n) {
        if (n == 0) {
            return 0;
        }
        else if (n == 1) {
            return 1;
        }
        else if (memo[n] == 0) {
            memo[n] = fib(n-1) + fib(n-2);
        }

        return memo[n];
    }
}
