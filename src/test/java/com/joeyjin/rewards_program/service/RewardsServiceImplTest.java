package com.joeyjin.rewards_program.service;

import com.joeyjin.rewards_program.entity.PurchaseEntity;
import com.joeyjin.rewards_program.entity.RewardEntity;
import org.junit.jupiter.api.Test;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class RewardsServiceImplTest {
    PurchaseEntity newPurchase(long cid, YearMonth ym, int amount) {
        PurchaseEntity p = new PurchaseEntity();
        p.setCustomerId(cid);
        p.setYearMonth(ym);
        p.setAmount(amount);
        return p;
    }

//    @Test
//    void aggregateRewardsTest() {
//        List<PurchaseEntity> purchases = new ArrayList<>();
//        PurchaseEntity p1 = newPurchase(1, YearMonth.of(2021,12),1);
//        PurchaseEntity p2 = newPurchase(1, YearMonth.of(2021,12),100);
//        PurchaseEntity p3 = newPurchase(1, YearMonth.of(2021,12),75);
//        PurchaseEntity p4 = newPurchase(1, YearMonth.of(2022,1),75);
//        PurchaseEntity p5 = newPurchase(2, YearMonth.of(2022,1),0);
//        purchases.addAll(new ArrayList<>(Arrays.asList(p1, p2, p3, p4, p5)));
//        Map<Long, Integer> map = RewardsServiceImpl.aggregateRewards(purchases);
//        assertEquals(50 + 25 + 25, map.get(1L));
//        assertEquals(0, map.get(2L));
//    }
//
//    @Test
//    void rewardsMap2ListTest() {
//        List<PurchaseEntity> purchases = new ArrayList<>();
//        PurchaseEntity p1 = newPurchase(1, YearMonth.of(2021,12),1);
//        PurchaseEntity p2 = newPurchase(1, YearMonth.of(2021,12),100);
//        PurchaseEntity p3 = newPurchase(1, YearMonth.of(2021,12),75);
//        PurchaseEntity p4 = newPurchase(1, YearMonth.of(2022,1),75);
//        PurchaseEntity p5 = newPurchase(2, YearMonth.of(2022,1),0);
//        purchases.addAll(new ArrayList<>(Arrays.asList(p1, p2, p3, p4, p5)));
//        Map<Long, Integer> map = RewardsServiceImpl.aggregateRewards(purchases);
//        List<RewardEntity> list = RewardsServiceImpl.rewardsMap2List(map, YearMonth.of(2021,12), 3);
//        assertEquals(2, list.size());
//        list.stream().forEach(System.out::println);
//    }

    @Test
    void findAllPurchasesWithin3MonthsTest() {
    }

    @Test
    void getMonthlyPointsTest() {
    }

    @Test
    void getTotalPointsWithin3MonthsTest() {
    }

    @Test
    void findAllPurchasesIn3Months() {
    }

    @Test
    void findAllPurchasesInAMonth() {
    }

    @Test
    void getMonthlyRewards() {
    }

    @Test
    void get3MonthsRewards() {
    }

}