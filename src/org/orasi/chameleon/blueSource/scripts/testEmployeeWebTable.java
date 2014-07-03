package org.orasi.chameleon.blueSource.scripts;

import java.util.List;
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
import org.orasi.chameleon.blueSource.resources.blueSourceLogin.blueSourceLoginMethods;
import org.orasi.chameleon.blueSource.resources.utilities.CONSTANTS;

public class testEmployeeWebTable {
	private WebDriver driver;
	
	private int getRowCount(WebElement table)
	{
		List<WebElement> rowCollection = table.findElements(By.xpath(".//tr"));
		return rowCollection.size();		 
	}
	
	private int getColumnCount(WebElement table, int row)
	{
		List<WebElement> rowCollection = table.findElements(By.xpath(".//tr"));
		int currentRow = 1;
		int columnCount = 0;
		String xpath = null;
		
		for(WebElement rowElement : rowCollection){
			if(row == currentRow){	
	        	driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
	        	
				if(rowElement.findElements(By.xpath("th")).size() != 0){
	        		xpath = "th";
	        	}else if(rowElement.findElements(By.xpath("td")).size() != 0){
	        		xpath = "td";
	        	//need to throw an exception
	        	}
	        	
	        	driver.manage().timeouts().implicitlyWait(CONSTANTS.TIMEOUT, TimeUnit.SECONDS);
	        	
				List<WebElement> columnCollection = rowElement.findElements(By.xpath(xpath));
				columnCount =columnCollection.size();	 
				break;
			}else{
				currentRow++;
			}			
		}
		
		return columnCount;
	}
	
	private String getCellData(WebElement tableElement, int row, int column){

		List<WebElement> rowCollection= tableElement.findElements(By.xpath(".//tr"));

        int currentRow = 1,currentColumn = 1;
        String xpath = null, cellData = "";        
        Boolean found = false;
        
        for(WebElement rowElement : rowCollection)
        {        	
        	if(row != currentRow){currentRow++;}
        	else{
			   	driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
	        	if(rowElement.findElements(By.xpath("th")).size() != 0)
	        	{
	        		xpath = "th";
	        	}else if(rowElement.findElements(By.xpath("td")).size() != 0)
	        	{
	        		xpath = "td";
	        	//need to throw an exception
	        	}
	        	
	        	driver.manage().timeouts().implicitlyWait(CONSTANTS.TIMEOUT, TimeUnit.SECONDS);
	        	
	            List<WebElement> columnCollection = rowElement.findElements(By.xpath(xpath));          
	            for(WebElement cell : columnCollection)
	            {	            	
					if (column != currentColumn){currentColumn++;}
					else
	            	{
	            		//System.out.println("row #:"+currentRow+", col #:"+currentColumn+ " text="+ cell.getText());
	            		cellData = cell.getText();
	            		found = true;
	            		break;
	            	}										
	            }
	            if (found){break;}
        	}        	
        }
		return cellData;     	
	}
	
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
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".table"))));
		
		System.out.println(getRowCount(tableElement));
		
		System.out.println(getColumnCount(tableElement,2));
		
		System.out.println(getCellData(tableElement,11,2));
			
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
    }
}
