package com.joeyjin.rewards_program.service;

import com.joeyjin.rewards_program.entity.PurchaseEntity;

import java.time.Month;
import java.util.List;
import java.util.Map;

public interface RewardsService {
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
    Integer calculatePoint(int amount);

    /**
     * Find all purchases that happen within three months.
     * @param start is the starting month of the period.
     * @return a List of all purchases within a 3-month period.
     */
    List<PurchaseEntity> findAllPurchasesWithin3Months(Month start);

    /**
     * Check if a purchase happens within an 3-month period.
     * CAUTION: cross year cases not considered. e.g: DEC, JAN, FEB...
     * @param start is the month the period begins with
     * @param monthToCheck is the month to check if it is in this n-month period
     * @return true, if the month to check is within this n-month period;
     *         false, if not.
     */
    boolean isWithin3Months(Month start, Month monthToCheck);

    /**
     * Get the rewards earned by every customer for a certain month.
     * @param purchases is a list of purchases.
     * @param month the month to calculate points.
     * @return a Map of the points earned per customer in this month.
     */
    Map<Long, Integer> getMonthlyPoints(List<PurchaseEntity> purchases, Month month);

    /**
     * Get the rewards earned by every customer in total.
     * @param purchases is a list of purchases.
     * @param start is the starting month of a 3-month period.
     * @return a Map of the points earned per customer in this month.
     */
    Map<Long, Integer> getTotalPointsWithin3Months(List<PurchaseEntity> purchases, Month start);
}
