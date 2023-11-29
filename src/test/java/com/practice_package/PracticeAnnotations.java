package com.practice_package;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class PracticeAnnotations {
	
	@BeforeSuite
	public void bs() {
		System.out.println("BS");
	}
	@BeforeClass
	public void bc() {
		System.out.println("Bc");
	}
	
	@BeforeClass
	public void bc1() {
		System.out.println("Bc1");
	}
	@Test
	public void test() {
		System.out.println("T1");
	}
	@BeforeMethod
	public void bm() {
		System.out.println("Bm");
	}
	@AfterMethod
	public void am() {
		System.out.println("Am");
	}
	@AfterClass
	public void ac() {
		System.out.println("Ac");
	}
	@Test
	public void test1() {
		System.out.println("T2");
	}
	@BeforeMethod
	public void bm1() {
		System.out.println("Bm1");
	}
	@AfterClass
	public void ac1() {
		System.out.println("Ac1");
	}
	@BeforeMethod
	public void bm2() {
		System.out.println("Bm2");
	}
	@AfterMethod
	public void am1() {
		System.out.println("Am1");
	}
	@AfterSuite
	public void as() {
		System.out.println("AS");
	}
	
	
	
	
}

