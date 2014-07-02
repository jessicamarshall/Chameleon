package org.orasi.chameleon.blueSource.resources.blueSourceLogin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.selophane.elements.*;
import org.selophane.elements.impl.internal.ElementFactory;

public class blueSourceLoginPage {
    public static blueSourceLoginPage initialize(WebDriver driver) {
        return ElementFactory.initElements(driver, blueSourceLoginPage.class);
    }
    
    @FindBy(id = "employee_username")
    public static Textbox txtUserName;
    
    @FindBy(id = "employee_password")
    public static Textbox txtPassWord;
    
    @FindBy(name = "commit")
    public static Button btnlogin;
}