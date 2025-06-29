package com.deepskilling;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class AssertionTest { 
    @Test 
    public void testAssertions() { 
        // Assert equals 
        assertEquals(5, 2 + 3); 
 
        // Assert true 
        assertTrue(5 > 3); 
 
        // Assert false 
        assertFalse(5 < 3); 
 
        // Assert null 
        assertNull(null); 
 
        // Assert not null 
        assertNotNull(new Object());
        	
        }
    public void testArrayAssertions() {
    	int []actual= {1,2,3};
    	int []expected= {1,2,3};
    	assertArrayEquals(expected,actual);
    }
}
