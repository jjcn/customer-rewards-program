package com.joeyjin.rewards_program.service;

import com.joeyjin.rewards_program.dao.PurchaseRepository;
import com.joeyjin.rewards_program.entity.PurchaseEntity;

import java.time.Month;
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
    public List<PurchaseEntity> findAllPurchasesWithin3Months(Month start) {
        return null;
    }


    @Override
    public boolean isWithin3Months(Month start, Month monthToCheck) {
        return false;
    }

    @Override
    public Map<Long, Integer> getMonthlyPoints(List<PurchaseEntity> purchases, Month month) {
        return null;
    }

    @Override
    public Map<Long, Integer> getTotalPointsWithin3Months(List<PurchaseEntity> purchases, Month start) {
        return null;
    }
}
