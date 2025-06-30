package com.learning;

public class MyService1 {
    private final ExternalApi1 api;

    public MyService1(ExternalApi1 api) {
        this.api = api;
    }

    public String fetchUser(String id) {
        return api.getUserData(id);
    }
}


