package com.deepskilling;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class EXERCISE4Test {

	@BeforeAll
	void beforeAll() {
		System.out.println("Before all tests");
	}
	@AfterAll
	void AfterAll() {
		System.out.println("After all tests");
	}
	EXERCISE4 shape;
	@BeforeEach
	void init(){
		shape = new EXERCISE4();
		System.out.println("Before test");
	}

	@Test
	void testComputeSquareArea() {
		assertEquals(25,shape.computeSquareArea(5));
		System.out.println("Actual square test running");
		
	}
	@Test
	void testComputeCircleArea() {
		assertEquals(78.5,shape.computeCircleArea(5));
		System.out.println("Actual circle test running");
	}
	@AfterEach
	void destroy() {
		System.out.println("After test");
	}
}
