package com.joeyjin.rewards_program.util;

import org.junit.jupiter.api.Test;

import java.time.YearMonth;

import static org.junit.jupiter.api.Assertions.*;

class MonthCheckerTest {

    @Test
    void isWithin3MonthsTest() {
        YearMonth ym1 = YearMonth.of(2021, 9);
        YearMonth ym2 = YearMonth.of(2021, 10);
        YearMonth ym3 = YearMonth.of(2021, 12);
        YearMonth ym4 = YearMonth.of(2022, 2);
        YearMonth ym5 = YearMonth.of(2022, 3);
        YearMonth ym6 = YearMonth.of(2022, 9);
        assertFalse(MonthChecker.isWithin3Months(ym1, ym3));
        assertTrue(MonthChecker.isWithin3Months(ym2, ym3));
        assertTrue(MonthChecker.isWithin3Months(ym3, ym4));
        assertFalse(MonthChecker.isWithin3Months(ym3, ym5));
        assertFalse(MonthChecker.isWithin3Months(ym1, ym6));
    }
}