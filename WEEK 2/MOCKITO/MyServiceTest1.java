package com.learning;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class MyServiceTest1 {

    @Test
    public void testVerifyWithArguments() {
        ExternalApi1 mockApi = mock(ExternalApi1.class);
        when(mockApi.getUserData("user123")).thenReturn("John Doe");
        MyService1 service = new MyService1(mockApi);
        String result = service.fetchUser("user123");
        assertEquals("John Doe", result);
        verify(mockApi).getUserData(eq("user123"));    
        }
}

