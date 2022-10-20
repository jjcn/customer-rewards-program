package com.joeyjin.rewards_program.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.YearMonth;

/**
 * A class for user rewards.
 * Consist of customer id, the year & month of the purchase, and the reward points earned for this month.
 */
public class RewardEntity {

    private Long customerId;

    /**
     * the starting year-month of a reward.
     */
    private YearMonth yearmonth;

    /**
     * The span of a reward.
     * if monthSpan = 1, it means this reward is earned in yearmonth;
     * if monthSpan = 3, it means this reward is earned in a 3-month period
     * starting from yearmonth(inclusive);
     */
    private Integer monthSpan;

    private Integer amount;

    public RewardEntity(Long customerId, YearMonth yearmonth, Integer monthSpan, Integer amount) {
        this.customerId = customerId;
        this.yearmonth = yearmonth;
        this.monthSpan = monthSpan;
        this.amount = amount;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public YearMonth getYearmonth() {
        return yearmonth;
    }

    public Integer getMonthSpan() {
        return monthSpan;
    }

    public Integer getAmount() {
        return amount;
    }
}
