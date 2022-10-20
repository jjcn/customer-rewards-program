package com.joeyjin.rewards_program.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;

/**
 * A class for customer purchase.
 * Consists of customer id, the year & month of the purchase, and the amount of purchase.
 */
@Entity
@Table(name = "purchase")
public class PurchaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @NotBlank
    @Column(name = "customerid")
    private Long customerId;

    @NotBlank
    @Column(name = "yearmonth")
    private YearMonth yearmonth;

    @NotBlank
    @Column(name = "amount")
    private Integer amount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public YearMonth getYearMonth() {
        return yearmonth;
    }

    public void setYearMonth(YearMonth yearmonth) {
        this.yearmonth = yearmonth;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
