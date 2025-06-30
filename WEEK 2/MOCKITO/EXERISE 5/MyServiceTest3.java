package com.learning;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

class MyServiceTest3{

	@Test
	public void testMultipleReturnValues() {
        ExternalApi3 mockApi = mock(ExternalApi3.class);
        when(mockApi.getData()).thenReturn("First").thenReturn("Second");
        MyService3 service = new MyService3(mockApi);
        String result = service.getFirstTwoResponses();
        assertEquals("First | Second", result);
    }
}
