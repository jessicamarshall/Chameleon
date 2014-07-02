package org.orasi.chameleon.blueSource.resources.blueSourceHomepage;

import org.openqa.selenium.WebDriver;

public class blueSourceHomepageMethods {
	private String strMainDepartment = "Services";
	private String strServicesDepartment = "Rural";
	
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

