package com.learning;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class MyServiceTest2 {

    @Test
    public void testVerifyWithArguments() {
        ExternalApi2 mockApi = mock(ExternalApi2.class);
        doNothing().when(mockApi).num(anyInt());
        MyService2 service=new MyService2(mockApi);
        service.run();
        verify(mockApi).num(2);
    }
}
//void