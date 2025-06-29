package com.learning;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ExceptionThrowerTest {

	@Test
	void testExceptionIsThrown() {
        ExceptionThrower thrower = new ExceptionThrower();

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> thrower.throwException(true)
            );
        assertEquals("Expected exception thrown", exception.getMessage());
    }
	@Test
    void testNoExceptionThrown() {
        ExceptionThrower thrower = new ExceptionThrower();
        assertDoesNotThrow(() -> thrower.throwException(false));
    }
}
