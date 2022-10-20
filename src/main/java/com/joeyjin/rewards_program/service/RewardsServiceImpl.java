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
    public List<PurchaseEntity> findAllPurchasesWithin3Months(YearMonth start) {
        return null;
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
