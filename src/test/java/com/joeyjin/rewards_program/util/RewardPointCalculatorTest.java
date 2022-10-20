package com.joeyjin.rewards_program.util;

import com.joeyjin.rewards_program.entity.PurchaseEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RewardPointCalculatorTest {

    @Test
    void calculatePointTest() {
        PurchaseEntity p1 = new PurchaseEntity(); p1.setAmount(-1);
        PurchaseEntity p2 = new PurchaseEntity(); p2.setAmount(0);
        PurchaseEntity p3 = new PurchaseEntity(); p3.setAmount(1);
        PurchaseEntity p4 = new PurchaseEntity(); p4.setAmount(50);
        PurchaseEntity p5 = new PurchaseEntity(); p5.setAmount(51);
        PurchaseEntity p6 = new PurchaseEntity(); p6.setAmount(100);
        PurchaseEntity p7 = new PurchaseEntity(); p7.setAmount(101);
        assertThrows(IllegalArgumentException.class, () -> RewardPointCalculator.calculatePoint(p1));
        assertEquals(0 , RewardPointCalculator.calculatePoint(p2));
        assertEquals(0 , RewardPointCalculator.calculatePoint(p3));
        assertEquals(0 , RewardPointCalculator.calculatePoint(p4));
        assertEquals(1 , RewardPointCalculator.calculatePoint(p5));
        assertEquals(50 , RewardPointCalculator.calculatePoint(p6));
        assertEquals(52 , RewardPointCalculator.calculatePoint(p7));
    }
}