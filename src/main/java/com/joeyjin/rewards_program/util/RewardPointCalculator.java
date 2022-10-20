package com.joeyjin.rewards_program.util;

public class RewardPointCalculator {
    /**
     * Calculate the points earned based on the amount spent.
     *
     * Rules:
     * 2 points for every dollar spent over $100 in each transaction,
     * plus 1 point for every dollar spent over $50 in each transaction.
     *
     * e.g. a $120 purchase = 2x$20 + 1x$50 = 90 points)
     * @param amount is the amount of money spent in one transaction.
     * @return the points earned through this transaction.
     */
    public static Integer calculatePoint(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("The amount of purchase should be a non-negative integer.");
        }
        Integer point = 1 * Math.min(50, Math.max(0, amount - 50)) + // 1 point for every dollar spent (50, 100]
                2 * Math.max(0, amount - 100); // 2 points for every dollar spent (100, +inf)
        return point;
    }
}
