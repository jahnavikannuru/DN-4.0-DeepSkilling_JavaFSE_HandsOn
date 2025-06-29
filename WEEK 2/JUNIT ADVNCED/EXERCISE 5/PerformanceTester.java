package com.learning;

public class PerformanceTester {
	public void performTask() {
		try {
			Thread.sleep(200);
		}
		catch(Exception e) {
			Thread.currentThread().interrupt();
		}
	}
}
