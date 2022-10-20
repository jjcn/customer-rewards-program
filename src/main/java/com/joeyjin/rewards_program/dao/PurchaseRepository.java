package com.joeyjin.rewards_program.dao;

import com.joeyjin.rewards_program.entity.PurchaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Month;
import java.util.List;

@Repository
public interface PurchaseRepository extends JpaRepository<PurchaseEntity, Long> {
    /**
     * Find a purchase record by the month.
     * @param month is a java.time.Month enum
     * @return a List of purchases
     */
    List<PurchaseEntity> findByMonth(Month month);
}
