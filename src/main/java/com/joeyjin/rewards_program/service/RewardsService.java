package com.joeyjin.rewards_program.service;

import com.joeyjin.rewards_program.entity.PurchaseEntity;

import java.time.YearMonth;
import java.util.List;
import java.util.Map;

public interface RewardsService {
    /**
     * Find all purchases that happen within three months.
     * @param start is the starting yearMonth of the period.
     * @return a List of all purchases within a 3-month period.
     */
    List<PurchaseEntity> findAllPurchasesWithin3Months(YearMonth start);

    /**
     * Get the rewards earned by every customer for a certain month.
     * @param purchases is a list of purchases.
     * @param yearMonth the yearMonth to calculate points.
     * @return a Map of the points earned per customer in this month.
     */
    Map<Long, Integer> getMonthlyPoints(List<PurchaseEntity> purchases, YearMonth yearMonth);

    /**
     * Get the rewards earned by every customer in total.
     * @param purchases is a list of purchases.
     * @param start is the starting yearMonth of a 3-month period.
     * @return a Map of the points earned per customer in this month.
     */
    Map<Long, Integer> getTotalPointsWithin3Months(List<PurchaseEntity> purchases, YearMonth start);
}
