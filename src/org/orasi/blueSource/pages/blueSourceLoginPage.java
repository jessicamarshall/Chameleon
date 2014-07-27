package org.orasi.blueSource.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.orasi.chameleon.interfaces.*;
import org.orasi.chameleon.interfaces.impl.internal.ElementFactory;

public class blueSourceLoginPage {
	private static WebDriver driver;

	public blueSourceLoginPage(WebDriver driver){
		blueSourceLoginPage.driver = driver;	
		ElementFactory.initElements(driver, this);	  
	}
	
    public static blueSourceLoginPage initialize() {
        return ElementFactory.initElements(driver, blueSourceLoginPage.class);
    }
    
    @FindBy(id = "employee_username")
    public static Textbox txtUserName;
    
    @FindBy(id = "employee_password")
    public static Textbox txtPassWord;
    
    @FindBy(name = "commit")
    public static Button btnlogin;
    
 public void login(String user, String pass) {        
    	
        //Build Page Object Repository
        initialize();

        //Set user name
       txtUserName.set(user);
        
        //Set password
       txtPassWord.set(pass);
        
        //Click login   
        btnlogin.click();
    }
}