package com.joeyjin.rewards_program.controller;

import com.joeyjin.rewards_program.entity.PurchaseEntity;
import com.joeyjin.rewards_program.entity.RewardEntity;
import com.joeyjin.rewards_program.service.RewardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.YearMonth;
import java.util.List;

@RestController
@RequestMapping("/api/rewards")
public class RewardsRestController {

    private RewardsService rewardsService;

    @Autowired
    public RewardsRestController(RewardsService rewardsService) {
        this.rewardsService = rewardsService;
    }

    @GetMapping(value = "/")
    public ResponseEntity<String> getRootpage()  {
        String rootpageMsg = "This is the Customer Rewards program API root.";
        return new ResponseEntity<>(rootpageMsg, HttpStatus.OK);
    }

    /**
     * Get the one-month rewards list per customer.
     * Example URL: /2020-01 or /1999-12
     * @param yearMonth is the year-month to calculate rewards
     * @return a JSON representation of monthly rewards.
     */
    @GetMapping(value = "/{yearMonth}")
    public ResponseEntity<?> getMonthlyRewards(@PathVariable("yearMonth") YearMonth yearMonth) {
//        System.out.println(yearMonth);
        List<RewardEntity> rewards = rewardsService.getMonthlyRewards(yearMonth);
//        System.out.println(rewards.size());
//        rewards.stream().forEach(System.out::println);
        return new ResponseEntity<List<RewardEntity>>(rewards, HttpStatus.OK);
    }

    /**
     * Testing
     * @return
     */
    @GetMapping(value = "/2021-12/test")
    public ResponseEntity<?> getCustomerPurchases() {
        return new ResponseEntity<List<RewardEntity>>(
                rewardsService.getMonthlyRewards(YearMonth.of(2021, 12)),
                HttpStatus.OK);
    }

    /**
     * Get the 3-months rewards list per customer.
     * Example URL: /2020-01/3-months-period or /1999-12/3-months-period
     * @param start is the year-month this period starts
     * @return a JSON representation of 3 months' rewards.
     */
    @GetMapping(value = "/{start}/3-months-period")
    public ResponseEntity<?> get3MonthRewards(@PathVariable("start") YearMonth start) {
        return new ResponseEntity<List<RewardEntity>>(rewardsService.get3MonthsRewards(start),
                HttpStatus.OK);
    }

}
