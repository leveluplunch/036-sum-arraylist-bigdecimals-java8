package com.levelup;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.junit.Before;
import org.junit.Test;

public class AddBigDecimals {

	List<BigDecimal> bigDecimalsValues = new ArrayList<>();

	@Before
	public void setUp() {
		bigDecimalsValues.add(new BigDecimal(1));
		bigDecimalsValues.add(new BigDecimal(2));
		bigDecimalsValues.add(new BigDecimal(3));
		bigDecimalsValues.add(new BigDecimal(4));
		bigDecimalsValues.add(new BigDecimal(5));

	}

	@Test
	public void add_big_decimals_java() {

		BigDecimal addBigDecimals = new BigDecimal(0);

		for (BigDecimal value : bigDecimalsValues) {
			addBigDecimals = addBigDecimals
					.add(new BigDecimal(value.intValue()));
		}

		assertEquals(new BigDecimal(15), addBigDecimals);
	}

	@Test
	public void add_big_decimals_java8() {

		BigDecimal sumOfBigDecimals = bigDecimalsValues.stream()
				.reduce(BigDecimal.ZERO, BigDecimal::add);

		assertEquals(new BigDecimal(15), sumOfBigDecimals);
	}

	@Test
	public void add_big_decimals_java8_null() {

		bigDecimalsValues.add(null);

		BigDecimal sumOfBigDecimals = bigDecimalsValues.stream()
				.filter(Objects::nonNull)
				.reduce(BigDecimal.ZERO, BigDecimal::add);

		assertEquals(new BigDecimal(15), sumOfBigDecimals);
	}

	class Car {

		private BigDecimal miles;

		public Car(BigDecimal miles) {
			super();
			this.miles = miles;
		}

		public BigDecimal getMiles() {
			return miles;
		}

		public void setMiles(BigDecimal miles) {
			this.miles = miles;
		}
	}

	@Test
	public void add_big_decimals_java8_object() {

		List<Car> vehicles = new ArrayList<>();
		vehicles.add(null);
		vehicles.add(new Car(null));
		vehicles.add(new Car(new BigDecimal("10")));
		vehicles.add(new Car(new BigDecimal("20")));

		BigDecimal sumOfBigDecimals = vehicles.stream()
				.filter(Objects::nonNull)
				.filter(c -> c.getMiles() != null)
				.map(Car::getMiles)
				.reduce(BigDecimal.ZERO, BigDecimal::add);

		assertEquals(new BigDecimal(30), sumOfBigDecimals);
	}

}
