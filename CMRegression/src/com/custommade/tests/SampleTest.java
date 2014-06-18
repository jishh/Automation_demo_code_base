package com.custommade.tests;

import org.testng.annotations.Test;

import com.custommade.configure.General;

public class SampleTest extends General {

	@Test
	public void sampleTest() {
		driver.get("http://www.google.com/");
	}
}
