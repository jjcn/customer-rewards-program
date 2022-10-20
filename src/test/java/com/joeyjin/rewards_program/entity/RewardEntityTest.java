package com.joeyjin.rewards_program.entity;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.time.YearMonth;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RewardEntityTest {

    RewardEntity reward1, reward2;

    @BeforeAll
    void init() {
        reward1 = new RewardEntity(1L, YearMonth.of(2021, 12), 1, 10);
        reward2 = new RewardEntity(2L, YearMonth.of(2022, 3), 3, 0);
    }

    @AfterEach
    void teardown() {
    }

    @Test
    void getCustomerIdTest() {
        assertEquals(1L, reward1.getCustomerId());
        assertEquals(2L, reward2.getCustomerId());
    }

    @Test
    void getYearmonthTest() {
        assertEquals(YearMonth.of(2021, 12), reward1.getYearmonth());
        assertEquals(YearMonth.of(2022, 3), reward2.getYearmonth());
    }

    @Test
    void getMonthSpanTest() {
        assertEquals(1, reward1.getMonthSpan());
        assertEquals(3, reward2.getMonthSpan());
    }

    @Test
    void getPointTest() {
        assertEquals(10, reward1.getPoint());
        assertEquals(0, reward2.getPoint());
    }
}