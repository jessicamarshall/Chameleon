package org.orasi.chameleon.blueSource.scripts;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.orasi.chameleon.blueSource.resources.blueSourceLogin.*;
import org.orasi.chameleon.blueSource.resources.blueSourceHomepage.*;


public class addEmployee {
	private WebDriver driver;
	
	@Before
	public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		driver.get("http://bluesourcestaging.herokuapp.com/login");    
	}
	  
	@Test
	public void main() throws Exception {	
		blueSourceLoginMethods blueSourceLogin= new blueSourceLoginMethods();			
		blueSourceLogin.login(driver);	
		
		blueSourceHomepageMethods blueSourceHomepage = new blueSourceHomepageMethods();
		blueSourceHomepage.addEmployee(driver);					
		
	}

	@After
	public void tearDown() throws Exception {
	//	driver.quit();
    }
}
