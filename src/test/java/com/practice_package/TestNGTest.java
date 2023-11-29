package com.practice_package;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGTest {
	
	@Test(invocationCount = 0)
	public void xcreate() {
		System.out.println("create");
		AssertJUnit.fail();
	}
	
	@Test
	public void edit() {
		System.out.println("edit");
	}
	
	@Test(invocationCount = 0)
	public void delete() {
		System.out.println("delete");
		
	}
	
	

}
