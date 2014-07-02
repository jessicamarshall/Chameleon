package org.orasi.chameleon.blueSource.resources.blueSourceLogin;

import org.openqa.selenium.WebDriver;


/**
 * The first page displayed in BLueSource
 */
public class blueSourceLoginMethods {

    public void login(WebDriver driver) {        
    	
        //Build Page Object Repository
        blueSourceLoginPage.initialize(driver);

        //Set user name
        blueSourceLoginPage.txtUserName.set("company.admin");
        
        //Set password
        blueSourceLoginPage.txtPassWord.set("anything");
        
        //Click login   
        blueSourceLoginPage.btnlogin.click();
    }
}
