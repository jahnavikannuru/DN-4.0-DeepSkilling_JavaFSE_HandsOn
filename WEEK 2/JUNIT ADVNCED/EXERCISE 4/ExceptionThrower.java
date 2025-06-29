package com.learning;

public class ExceptionThrower {
    public void throwException(boolean shouldThrow) {
        if (shouldThrow) {
            throw new IllegalArgumentException("Expected exception thrown");
        }
    }
}
