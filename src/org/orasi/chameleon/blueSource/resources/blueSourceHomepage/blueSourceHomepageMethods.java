package org.orasi.chameleon.blueSource.resources.blueSourceHomepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.orasi.chameleon.blueSource.resources.utilities.CONSTANTS;

public class blueSourceHomepageMethods {
	
	//Declare variables here
	private String strMainDepartment = "Services";
	private String strServicesDepartment = "Rural";
	
	/*
	 * Can be used as the Homepage loads to ensure all objects are loaded before continuing
	 */
	public void waitUntilEmployeeTableLoads(WebDriver driver)
	{
		blueSourceHomepagePage.initialize(driver);
		WebDriverWait wait = new WebDriverWait(driver, CONSTANTS.TIMEOUT);
		wait.until(ExpectedConditions.visibilityOf(blueSourceHomepagePage.tblEmployees));
	}
	

	/*
	 * Testing Webtable functionality
	 */
	public void testWebtableObjects(WebDriver driver){
		blueSourceHomepagePage.initialize(driver);
		System.out.println("Get Row Count: " + blueSourceHomepagePage.tblEmployees.getRowCount());
		
		System.out.println("Get Column Count: " + blueSourceHomepagePage.tblEmployees.getColumnCount(driver, 1));			
	
		System.out.println("Get Row number with Cell Text 'Otherthomas': " + blueSourceHomepagePage.tblEmployees.getRowWithCellText(driver,"Otherthomas"));			
		
		System.out.println("Get Row number with Cell Text 'Gonzalez' in Column 2 and starting at row 15: " +blueSourceHomepagePage.tblEmployees.getRowWithCellText(driver, "Gonzalez",2,15));
		
		System.out.println("Get Column number with Cell Text 'Last Name': " + blueSourceHomepagePage.tblEmployees.getColumnWithCellText(driver,"Last Name"));
		
		System.out.println("Get Row number with Cell Text 'Dargatz' and Column Header 'Last Name': " + blueSourceHomepagePage.tblEmployees.getRowWithCellText(driver,"Dargatz", 
							blueSourceHomepagePage.tblEmployees.getColumnWithCellText(driver,"Last Name")));
		
		System.out.println("Get Cell Data for 10,2: " + blueSourceHomepagePage.tblEmployees.getCellData(driver, 10, 2));
		
		System.out.println("Get Column number with Cell Text 'Location' : " + blueSourceHomepagePage.tblEmployees.getColumnWithCellText(driver,"Location"));
	}
	
	/*
	 * Goes through the process of adding an employee
	 */
	public void addEmployee(WebDriver driver){
        //Build Page Object Repository
		blueSourceHomepagePage.initialize(driver);
		
		//Click to open Add Employees to Directory Window
		blueSourceHomepagePage.btnDirectoryAdd.click();
		
		// Add Employee Data
		blueSourceHomepagePage.txtUserName.set("Testuser234235");
		
		blueSourceHomepagePage.txtFirstName.set("Testuser");
		
		blueSourceHomepagePage.txtLastName.set("234235");
		
		blueSourceHomepagePage.lstTitle.select("Consultant");
		
		blueSourceHomepagePage.lstRole.select("Base");
		
		blueSourceHomepagePage.lstManager.select("Waightstill Avery");
		
		blueSourceHomepagePage.txtBridgeTime.set("1");
		
		blueSourceHomepagePage.lstLocation.select("Remote");
		
		blueSourceHomepagePage.txtStartDate.set("2012-11-11");
		
		blueSourceHomepagePage.txtCellPhone.set("3363363366");
		
		blueSourceHomepagePage.txtOfficePhone.set("3366633366");
		
		blueSourceHomepagePage.txtEmail.set("test@test.com");
		
		blueSourceHomepagePage.txtIMName.set("Testuser2345645");
		
		blueSourceHomepagePage.lstIMClient.select("Skype");
		
		blueSourceHomepagePage.lstMainDepartment.select(strMainDepartment);
		
		if (strMainDepartment.toString() == "Services") {
			
			blueSourceHomepagePage.lstServicesDepartment.select(strServicesDepartment);
			
			if (strServicesDepartment.toString() == "Rural") {
				
				blueSourceHomepagePage.lstSubDepartment.select("BlueSource® Team");
			}	
		}		
		
		//Click Create to commit data
		blueSourceHomepagePage.btnCreate.click();
				
	}

}

