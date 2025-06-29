package com.deepskilling;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

class Exercise2Test {
	Exercise2 ex=new Exercise2();
	@Test
	void testAdd() {
		assertEquals(5,ex.add(3,2));
	}
	void testSub() {
		assertEquals(1,ex.sub(3,2));
	}
	void testMul() {
		assertEquals(6,ex.mul(3,2));
	}
	void testDiv() {
		assertEquals(3,ex.add(6,2));
	}
	
}
