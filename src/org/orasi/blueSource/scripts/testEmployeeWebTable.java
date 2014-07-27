package org.orasi.blueSource.scripts;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.orasi.blueSource.pages.blueSourceHomepage;
import org.orasi.blueSource.pages.blueSourceLoginPage;
import org.orasi.chameleon.utilities.CONSTANTS;

public class testEmployeeWebTable {
	private WebDriver driver;
	

	@Before
	public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    driver.manage().timeouts().implicitlyWait(CONSTANTS.TIMEOUT, TimeUnit.SECONDS);	
		driver.get(CONSTANTS.URL);    
	}
	  
	@Test
	public void main() throws Exception {	
		
		blueSourceLoginPage Login= new blueSourceLoginPage(driver);			
		Login.login("company.admin","anything");	
				
		blueSourceHomepage Homepage = new blueSourceHomepage(driver);
		
		Homepage.testWebtableObjects();
		
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
    }
}
