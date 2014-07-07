package org.orasi.chameleon.blueSource.scripts;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.orasi.chameleon.blueSource.resources.blueSourceHomepage.blueSourceHomepageMethods;
import org.orasi.chameleon.blueSource.resources.blueSourceLogin.blueSourceLoginMethods;
import org.orasi.chameleon.blueSource.resources.utilities.CONSTANTS;

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
		
		blueSourceLoginMethods blueSourceLogin= new blueSourceLoginMethods();			
		blueSourceLogin.login(driver);	
				
		blueSourceHomepageMethods blueSourceHomepage = new blueSourceHomepageMethods();
		
		blueSourceHomepage.waitUntilEmployeeTableLoads(driver);
		
		blueSourceHomepage.testWebtableObjects(driver);
		
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
    }
}
