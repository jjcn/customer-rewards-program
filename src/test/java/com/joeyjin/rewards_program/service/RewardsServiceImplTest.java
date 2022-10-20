package com.joeyjin.rewards_program.service;

import org.junit.jupiter.api.Test;

import java.time.YearMonth;

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
    void isWithin3MonthsTest() {
        YearMonth ym1 = YearMonth.of(2021, 9);
        YearMonth ym2 = YearMonth.of(2021, 10);
        YearMonth ym3 = YearMonth.of(2021, 12);
        YearMonth ym4 = YearMonth.of(2022, 2);
        YearMonth ym5 = YearMonth.of(2022, 3);
        YearMonth ym6 = YearMonth.of(2022, 9);
        assertFalse(rs.isWithin3Months(ym1, ym3));
        assertTrue(rs.isWithin3Months(ym2, ym3));
        assertTrue(rs.isWithin3Months(ym3, ym4));
        assertFalse(rs.isWithin3Months(ym3, ym5));
        assertFalse(rs.isWithin3Months(ym1, ym6));
    }

    @Test
    void getMonthlyPointsTest() {
    }

    @Test
    void getTotalPointsWithin3MonthsTest() {
    }
}