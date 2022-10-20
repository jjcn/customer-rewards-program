package com.joeyjin.rewards_program.util;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.time.YearMonth;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class YearMonthTypeDescriptorTest {

    YearMonth ym200011, ym202011, ym202012, ym000001;
    YearMonthTypeDescriptor descriptor;
    @BeforeAll
    void init() {
        ym200011 = YearMonth.of(2000, 11);
        ym202011 = YearMonth.of(2020, 11);
        ym202012 = YearMonth.of(2020, 12);
        ym000001 = YearMonth.of(0, 1);
        descriptor = new YearMonthTypeDescriptor();
    }

    @Test
    void areEqual() {
        assertTrue(descriptor.areEqual(ym200011, ym200011));
        assertFalse(descriptor.areEqual(ym200011, ym202011));
        assertFalse(descriptor.areEqual(ym202011, ym202012));
    }

    @Test
    void testToString() {
        assertEquals("2000-11", descriptor.toString(ym200011));
        assertEquals("2020-11", descriptor.toString(ym202011));
        assertEquals("0000-01", descriptor.toString(ym000001));
    }

    @Test
    void fromString() {
        assertEquals(ym200011, descriptor.fromString("2000-11"));
        assertEquals(ym202011, descriptor.fromString("2020-11"));
        assertEquals(ym000001, descriptor.fromString("0000-01"));
    }
}