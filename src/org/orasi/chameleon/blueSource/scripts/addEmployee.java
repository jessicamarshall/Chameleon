package org.orasi.chameleon.blueSource.scripts;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.orasi.chameleon.blueSource.resources.blueSourceHomepage.blueSourceHomepageMethods;
import org.orasi.chameleon.blueSource.resources.blueSourceLogin.blueSourceLoginMethods;
import org.orasi.chameleon.blueSource.resources.utilities.CONSTANTS;


public class addEmployee {
	private WebDriver driver;
	
	
	@Before
	public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		driver.get(CONSTANTS.URL);    
	}
	  
	@Test
	public void main() throws Exception {	
		blueSourceLoginMethods blueSourceLogin= new blueSourceLoginMethods();			
		blueSourceLogin.login(driver);	
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		WebElement tableElement = driver.findElement(By.cssSelector(".table"));
		wait.until(ExpectedConditions.visibilityOf(tableElement));
				
		blueSourceHomepageMethods blueSourceHomepage = new blueSourceHomepageMethods();
		blueSourceHomepage.addEmployee(driver);					
		
	}

	@After
	public void tearDown() throws Exception {
		//driver.quit();
    }
}
