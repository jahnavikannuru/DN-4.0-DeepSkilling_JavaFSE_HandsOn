package com.learning;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SubtractionTest {

	@Test
	void testSubtraction()
    {
        Calculator calculator = new Calculator();
        assertEquals(2, calculator.subtract(5, 3));
    }
}
