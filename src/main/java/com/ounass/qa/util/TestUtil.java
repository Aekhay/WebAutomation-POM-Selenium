package com.ounass.qa.util;

import com.ounass.qa.base.TestBase;

public class TestUtil extends TestBase{
	
	//Defining wait timeout for pageload/implicit to changes values globally
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;
	
	String framename;
	
	//Switching to frame if needed
	public void switchToFrame() {
		driver.switchTo().frame(framename);
	}

}
