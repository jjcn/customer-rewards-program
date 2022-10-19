package com.joeyjin.rewardsProgram.entity;

import org.junit.jupiter.api.Test;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class PurchaseEntityTest {

    PurchaseEntity generateDummy(Long id, Month month, Integer amount) {
        PurchaseEntity dummy = new PurchaseEntity();
        dummy.setId(id);
        dummy.setMonth(month);
        dummy.setAmount(amount);
        return dummy;
    }

    PurchaseEntity generate0() {
        return generateDummy(1L, Month.JANUARY,0);
    }

    PurchaseEntity generate100() {
        return generateDummy(2L, Month.FEBRUARY,100);
    }

    @Test
    void getId() {
        assertEquals(Long.valueOf(1), generate0().getId());
        assertEquals(Long.valueOf(2), generate100().getId());
    }

    @Test
    void setId() {
        PurchaseEntity dummy = new PurchaseEntity();
        dummy.setId(1L);
        assertEquals(Long.valueOf(1), dummy.getId());
        assertEquals(null, dummy.getMonth());
        assertEquals(null, dummy.getAmount());
    }

    @Test
    void getMonth() {
        assertEquals(Month.JANUARY, generate0().getMonth());
        assertEquals(Month.FEBRUARY, generate100().getMonth());
    }

    @Test
    void setMonth() {
        PurchaseEntity dummy = new PurchaseEntity();
        dummy.setMonth(Month.OCTOBER);
        assertEquals(null, dummy.getId());
        assertEquals(Month.OCTOBER, dummy.getMonth());
        assertEquals(null, dummy.getAmount());
    }

    @Test
    void getAmount() {
        assertEquals(0, generate0().getAmount());
        assertEquals(100, generate100().getAmount());
    }

    @Test
    void setAmount() {
        PurchaseEntity dummy = new PurchaseEntity();
        dummy.setAmount(Integer.MAX_VALUE);
        assertEquals(null, dummy.getId());
        assertEquals(null, dummy.getMonth());
        assertEquals(Integer.MAX_VALUE, dummy.getAmount());
    }
}