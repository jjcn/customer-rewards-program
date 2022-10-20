package com.joeyjin.rewards_program.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RewardsServiceImplTest {

    RewardsService rs = new RewardsServiceImpl();

    @Test
    void calculatePointTest() {
        assertThrows(IllegalArgumentException.class, () -> rs.calculatePoint(-1));
        assertEquals(0 , rs.calculatePoint(0));
        assertEquals(0 , rs.calculatePoint(1));
        assertEquals(0 , rs.calculatePoint(50));
        assertEquals(1 , rs.calculatePoint(51));
        assertEquals(50 , rs.calculatePoint(100));
        assertEquals(52 , rs.calculatePoint(101));
        assertEquals(52 , rs.calculatePoint(101));
    }

    @Test
    void findAllPurchasesWithin3MonthsTest() {
    }

    @Test
    void isWithinNMonthsTest() {
    }

    @Test
    void isWithin3MonthsTest() {
    }

    @Test
    void getMonthlyPointsTest() {
    }

    @Test
    void getTotalPointsWithin3MonthsTest() {
    }
}