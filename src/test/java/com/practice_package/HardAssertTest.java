package com.practice_package;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class HardAssertTest {

	String b;
	@Test
	public void hard() {
		
		
		System.out.println("1");
		System.out.println("2");
		assertEquals("A", "B");
		System.out.println("3");
		System.out.println("4");
		
	}
	
	@Test
	public void hard1() {
		
		int a=10;
		System.out.println("5");
		System.out.println("6");
		assertNull(a);
		System.out.println("7");
		System.out.println("8");
		
	}
	
	@Test
	public void hard2() {
		
		int a;
		System.out.println("9");
		System.out.println("10");
	assertNotNull(b);
		System.out.println("11");
		System.out.println("12");
		
	}
}
