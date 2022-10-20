package com.joeyjin.rewards_program.util;

import org.hibernate.type.AbstractSingleColumnStandardBasicType;
import org.hibernate.type.descriptor.sql.IntegerTypeDescriptor;

import java.time.YearMonth;

/**
 * A type to convert YearMonth to Integer for Hibernate persistence.
 * e.g. 2021 January -> 202101
 */
public class YearMonthIntegerType extends AbstractSingleColumnStandardBasicType<YearMonth> {

    public static final YearMonthIntegerType INSTANCE =
            new YearMonthIntegerType();

    public YearMonthIntegerType() {
        super(IntegerTypeDescriptor.INSTANCE,
                YearMonthTypeDescriptor.INSTANCE);
    }

    public String getName() {
        return "yearMonth2int";
    }

    @Override
    protected boolean registerUnderJavaType() {
        return true;
    }
}