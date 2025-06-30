package com.learning;

public class MyService3 {
	private final ExternalApi3 api;

    public MyService3(ExternalApi3 api) {
        this.api =api;
    }

    public String getFirstTwoResponses() {
        return api.getData() + " | " + api.getData();
    }
}
