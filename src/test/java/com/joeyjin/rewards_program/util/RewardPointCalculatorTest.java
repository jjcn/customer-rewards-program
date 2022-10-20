package com.joeyjin.rewards_program.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RewardPointCalculatorTest {

    @Test
    void calculatePointTest() {
        assertThrows(IllegalArgumentException.class, () -> RewardPointCalculator.calculatePoint(-1));
        assertEquals(0 , RewardPointCalculator.calculatePoint(0));
        assertEquals(0 , RewardPointCalculator.calculatePoint(1));
        assertEquals(0 , RewardPointCalculator.calculatePoint(50));
        assertEquals(1 , RewardPointCalculator.calculatePoint(51));
        assertEquals(50 , RewardPointCalculator.calculatePoint(100));
        assertEquals(52 , RewardPointCalculator.calculatePoint(101));
        assertEquals(52 , RewardPointCalculator.calculatePoint(101));
    }
}