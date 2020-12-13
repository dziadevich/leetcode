package easy;

import java.util.stream.IntStream;

/**
 * You are given an m x n integer grid accounts where accounts[i][j]
 * is the amount of money the i​​th​customer has in the j​​th​​bank.
 * Return the wealth that the richest customer has.
 * <p>
 * A customer's wealth is the amount of money they have in all their bank accounts.
 * The richest customer is the customer that has the maximum wealth.
 */
public class RichestCustomerWealth {

    public static int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int[] account : accounts) {
            int newSum = IntStream.of(account).sum();
            if (max < newSum)
                max = newSum;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(
                RichestCustomerWealth.maximumWealth(
                        new int[][]{{1, 2, 3}, {3, 2, 1}}));
    }
}
