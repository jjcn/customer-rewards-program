package com.joeyjin.rewards_program;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.*;

@SpringBootTest
class RewardsProgramApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void sketches() {
//		System.out.println(Month.MARCH.getValue() - Month.JANUARY.getValue());
//		System.out.println(Month.JANUARY.getValue() - Month.NOVEMBER.getValue());
		YearMonth ym1 = YearMonth.of(2022,12);
		YearMonth ym2 = YearMonth.of(2023,2);
		YearMonth ym3 = ym1.plusMonths(2);
		System.out.println(ym3);
		System.out.println(ym3.equals(ym2));
		System.out.print(ym3.isAfter(ym2));
	}
}
