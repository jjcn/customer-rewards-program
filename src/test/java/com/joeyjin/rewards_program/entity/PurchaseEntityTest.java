package com.joeyjin.rewards_program.entity;

import org.junit.jupiter.api.Test;

import java.time.YearMonth;

import static org.junit.jupiter.api.Assertions.*;

class PurchaseEntityTest {

    PurchaseEntity generateDummy(Long id, YearMonth yearMonth, Integer amount) {
        PurchaseEntity dummy = new PurchaseEntity();
        dummy.setId(id);
        dummy.setYearMonth(yearMonth);
        dummy.setAmount(amount);
        return dummy;
    }

    PurchaseEntity generate0() {
        return generateDummy(1L, YearMonth.of(2022, 1),0);
    }

    PurchaseEntity generate100() {
        return generateDummy(2L, YearMonth.of(2022, 2),100);
    }

    @Test
    void getIdTest() {
        assertEquals(Long.valueOf(1), generate0().getId());
        assertEquals(Long.valueOf(2), generate100().getId());
    }

    @Test
    void setIdTest() {
        PurchaseEntity dummy = new PurchaseEntity();
        dummy.setId(1L);
        assertEquals(Long.valueOf(1), dummy.getId());
        assertNull(dummy.getYearMonth());
        assertNull(dummy.getAmount());
    }

    @Test
    void getMonthTest() {
        assertEquals(YearMonth.of(2022, 1), generate0().getYearMonth());
        assertEquals(YearMonth.of(2022, 2), generate100().getYearMonth());
    }

    @Test
    void setMonthTest() {
        PurchaseEntity dummy = new PurchaseEntity();
        dummy.setYearMonth(YearMonth.of(2022, 10));
        assertNull(dummy.getId());
        assertEquals(YearMonth.of(2022, 10), dummy.getYearMonth());
        assertNull(dummy.getAmount());
    }

    @Test
    void getAmountTest() {
        assertEquals(0, generate0().getAmount());
        assertEquals(100, generate100().getAmount());
    }

    @Test
    void setAmountTest() {
        PurchaseEntity dummy = new PurchaseEntity();
        dummy.setAmount(Integer.MAX_VALUE);
        assertNull(dummy.getId());
        assertNull(dummy.getYearMonth());
        assertEquals(Integer.MAX_VALUE, dummy.getAmount());
    }
}