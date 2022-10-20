package com.joeyjin.rewards_program.service;

import com.joeyjin.rewards_program.dao.PurchaseRepository;
import com.joeyjin.rewards_program.entity.PurchaseEntity;
import com.joeyjin.rewards_program.entity.RewardEntity;
import com.joeyjin.rewards_program.util.MonthChecker;
import com.joeyjin.rewards_program.util.RewardPointCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.YearMonth;
import java.util.*;
import java.util.stream.Collectors;

@Service("rewardsService")
public class RewardsServiceImpl implements RewardsService {
    private PurchaseRepository purchaseRepo;

    @Autowired
    public RewardsServiceImpl(PurchaseRepository purchaseRepo) {
        this.purchaseRepo = purchaseRepo;
    }

    @Override
    public List<PurchaseEntity> findAllPurchasesIn3Months(YearMonth start) {
        return purchaseRepo.findAll().stream()
                .filter(purchase -> MonthChecker.isWithin3Months(start, purchase.getYearMonth()))
                .collect(Collectors.toList());
    }

    @Override
    public List<PurchaseEntity> findAllPurchasesInAMonth(YearMonth targetYearMonth) {
        return purchaseRepo.findAll().stream()
                .filter(purchase -> targetYearMonth.equals(purchase.getYearMonth()))
                .collect(Collectors.toList());
    }

    /**
     * Aggregate separate purchase records to reward records.
     * @param purchases is a List og purchase records
     * @return a Map : customer id -> reward points
     */
    private Map<Long, Integer> aggregateRewards(List<PurchaseEntity> purchases) {
        Map<Long, Integer> rewardsMap = new TreeMap<>(); // a map storing the rewards for every customer
        for (PurchaseEntity p : purchases) {
            Integer point = RewardPointCalculator.calculatePoint(p);
            Long cid = p.getCustomerId();
            rewardsMap.put(cid, rewardsMap.getOrDefault(cid, 0) + point);
        }
        return rewardsMap;
    }

    /**
     * Convert the rewards Map to a List.
     * @param rewardsMap is a Map : customer id -> reward points
     * @param start is the starting month of a period
     * @param monthPeriod is the number of months in the period
     * @return a list of n-months rewards of a customer.
     */
    private  List<RewardEntity> rewardsMap2List(Map<Long, Integer> rewardsMap,
                                                YearMonth start,
                                                Integer monthPeriod) {
        List<RewardEntity> manyMonthRewards = new ArrayList<>();
        for (Map.Entry<Long, Integer> entry : rewardsMap.entrySet()) {
            Long cid = entry.getKey();
            int amount = entry.getValue();
            RewardEntity reward = new RewardEntity(cid, start, monthPeriod, amount);
            manyMonthRewards.add(reward);
        }
        return manyMonthRewards;
    }

    @Override
    public List<RewardEntity> getMonthlyRewards(YearMonth targetYearMonth) {
        Map<Long, Integer> rewardsMap = aggregateRewards(findAllPurchasesInAMonth(targetYearMonth));
        return rewardsMap2List(rewardsMap, targetYearMonth, 1);
    }

    @Override
    public List<RewardEntity> getTotalPointsWithin3Months(YearMonth start) {
        Map<Long, Integer> rewardsMap = aggregateRewards(findAllPurchasesIn3Months(start));
        return rewardsMap2List(rewardsMap, start, 3);
    }

}
