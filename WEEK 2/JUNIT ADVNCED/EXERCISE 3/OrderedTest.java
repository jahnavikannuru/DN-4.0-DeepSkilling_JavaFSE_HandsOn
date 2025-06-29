package com.learning;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class) // Enables ordering using @Order
public class OrderedTest {
    @Test
    @Order(1)
    void testFirst() {
        System.out.println("in testFirst()");
        assertTrue(true);
    }
    @Test
    @Order(3)
    void testThird() {
        System.out.println("in testThird()");
        assertTrue(true);
    }
    @Test
    @Order(2)
    void testSecond() {
        System.out.println("in testSecond()");
        assertTrue(true);
    }
}
