package com.joeyjin.rewards_program.entity;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.YearMonth;

import static org.junit.jupiter.api.Assertions.*;

class PurchaseEntityTest {

    /**
     * Helper functions
     */
    PurchaseEntity newPurhcase(Long id, YearMonth yearMonth, Integer amount) {
        PurchaseEntity dummy = new PurchaseEntity();
        dummy.setId(id);
        dummy.setYearMonth(yearMonth);
        dummy.setAmount(amount);
        return dummy;
    }
    /**
     * End of helper functions
     */

    private PurchaseEntity dummy, p0, p100;

    @BeforeEach
    void init() {
        dummy = new PurchaseEntity();
        p0 = newPurhcase(1L, YearMonth.of(2022, 1),0);
        p100 = newPurhcase(2L, YearMonth.of(2022, 2),100);
    }

    @AfterEach
    void teardown() {
    }

    @Test
    void getIdTest() {
        assertEquals(Long.valueOf(1), p0.getId());
        assertEquals(Long.valueOf(2), p100.getId());
    }

    @Test
    void setIdTest() {
        dummy.setId(1L);
        assertEquals(Long.valueOf(1), dummy.getId());
        assertNull(dummy.getYearMonth());
        assertNull(dummy.getAmount());
    }

    @Test
    void getMonthTest() {
        assertEquals(YearMonth.of(2022, 1), p0.getYearMonth());
        assertEquals(YearMonth.of(2022, 2), p100.getYearMonth());
    }

    @Test
    void setMonthTest() {
        dummy.setYearMonth(YearMonth.of(2022, 10));
        assertNull(dummy.getId());
        assertEquals(YearMonth.of(2022, 10), dummy.getYearMonth());
        assertNull(dummy.getAmount());
    }

    @Test
    void getAmountTest() {
        assertEquals(0, p0.getAmount());
        assertEquals(100, p100.getAmount());
    }

    @Test
    void setAmountTest() {
        dummy.setAmount(Integer.MAX_VALUE);
        assertNull(dummy.getId());
        assertNull(dummy.getYearMonth());
        assertEquals(Integer.MAX_VALUE, dummy.getAmount());
    }
}