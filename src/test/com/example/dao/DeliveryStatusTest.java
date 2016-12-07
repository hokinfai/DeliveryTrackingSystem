package com.example.dao;

import static org.junit.Assert.*;

import org.junit.Test;

public class DeliveryStatusTest {

	@Test
	public void test() {
		DeliveryStatus ds = DeliveryStatus.ARRIVED;
		assertTrue(ds.toString().compareToIgnoreCase("Arrived") == 0);

	}

}
