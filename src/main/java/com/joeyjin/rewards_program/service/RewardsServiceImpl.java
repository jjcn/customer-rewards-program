package com.joeyjin.rewards_program.service;

import com.joeyjin.rewards_program.dao.PurchaseRepository;
import com.joeyjin.rewards_program.entity.PurchaseEntity;

import java.time.Month;
import java.time.YearMonth;
import java.util.List;
import java.util.Map;

public class RewardsServiceImpl implements RewardsService {
    private PurchaseRepository purchaseRepo;

    @Override
    public Integer calculatePoint(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("The amount of purchase should be a non-negative integer.");
        }
        Integer point = 1 * Math.min(50, Math.max(0, amount - 50)) + // 1 point for every dollar spent (50, 100]
                        2 * Math.max(0, amount - 100); // 2 points for every dollar spent (100, +inf)
        return point;
    }

    @Override
    public List<PurchaseEntity> findAllPurchasesWithin3Months(YearMonth start) {
        return null;
    }

    @Override
    public boolean isWithin3Months(YearMonth start, YearMonth yearMonthToCheck) {
        YearMonth end = start.plusMonths(2); // the starting month is included in the period
        System.out.println(end);
        return  (start.equals(yearMonthToCheck) | start.isBefore(yearMonthToCheck)) &
                (end.equals(yearMonthToCheck) | end.isAfter(yearMonthToCheck));
    }

    @Override
    public Map<Long, Integer> getMonthlyPoints(List<PurchaseEntity> purchases, YearMonth month) {
        return null;
    }

    @Override
    public Map<Long, Integer> getTotalPointsWithin3Months(List<PurchaseEntity> purchases, YearMonth start) {
        return null;
    }

}
