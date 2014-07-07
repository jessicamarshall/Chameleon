package org.orasi.chameleon.blueSource.resources.blueSourceHomepage;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.selophane.elements.*;
import org.selophane.elements.impl.internal.ElementFactory;

public class blueSourceHomepagePage {

	public static blueSourceHomepagePage initialize(WebDriver driver) {
        return ElementFactory.initElements(driver, blueSourceHomepagePage.class);	        
	}
	
	//******************************
	//*** Main Homepage Elements ***
	//******************************
			
	//Create Button for Return Home icon in top left of screen
    @FindBy(className = "navbar-toggle")
    public static Button btnReturnHome;
    
    //Create Element for the Menubar Admin selection
    @FindBy(className = "dropdown")
    public static Element eleMenuBarAdmin;
    
    //Create Button for AllButton
    @FindBy(id = "option1")
    public static Button btnDirectoryAll;
    
    //Create Button for Direct Button
    @FindBy(id = "option2")
    public static Button btnDirectoryDirect;
    
    //Create Button for Add Button
    @FindBy(name = "button")
    public static Button btnDirectoryAdd;
    
    //Create Textbox for Search Employees
    @FindBy(id = "search-bar")
    public static Textbox txtSearchEmployee;
    
    //Create Webtable for Employees
    @FindBy(css = ".table")
    public static Webtable tblEmployees;
    
	//****************************
	//*** Add Employee Elements***
	//****************************
	
    //Create Editbox for Employee User Name
    @FindBy(id = "employee_username")
    public static Textbox txtUserName;
    
    //Create Editbox for Employee First Name
    @FindBy(id = "employee_first_name")
    public static Textbox txtFirstName;
    
    //Create Editbox for Employee Last Name
    @FindBy(id = "employee_last_name")
    public static Textbox txtLastName;
    
    //Create Editbox for Employee Bridge Time
    @FindBy(id = "employee_bridge_time")
    public static Textbox txtBridgeTime;
    
    //Create Editbox for Employee Start Date
    @FindBy(id = "employee_start_date")
    public static Textbox txtStartDate;
    
    //Create Editbox for Employee Cell Phone
    @FindBy(id = "employee_cell_phone")
    public static Textbox txtCellPhone;
    
    //Create Editbox for Employee Office Phone
    @FindBy(id = "employee_office_phone")
    public static Textbox txtOfficePhone;
    
    //Create Editbox for Employee Email
    @FindBy(id = "employee_email")
    public static Textbox txtEmail;
    
    //Create Editbox for Employee IM Name
    @FindBy(id = "employee_im_name")
    public static Textbox txtIMName;

    //Create Listbox for Employee Title
    @FindBy(id = "employee_title_id")
    public static Listbox lstTitle;

    //Create Listbox for Employee Role
    @FindBy(id = "employee_role")
    public static Listbox lstRole;

    //Create Listbox for Employee Manager Name
    @FindBy(id = "employee_manager_id")
    public static Listbox lstManager;
    
    //Create Listbox for Employee Status
    @FindBy(id = "employee_status")
    public static Listbox lstSTatus;
    
    //Create Listbox for Employee Location
    @FindBy(id = "employee_location")
    public static Listbox lstLocation;
    
    //Create Listbox for Employee IM CLient
    @FindBy(id = "employee_im_client")
    public static Listbox lstIMClient;
    
    //Create Listbox for Employee Main Department ID
    @FindBy(id = "employee_department_id")
    public static Listbox lstMainDepartment;
    
    //Create Listbox for Employee Serrvices Department ID
    @FindBy(css = "div.form-group:nth-child(17) > select:nth-child(3)")
    public static Listbox lstServicesDepartment;
    
    
  //Create Listbox for Employee Sub Department ID
    @FindBy(css = "select.form-control:nth-child(4)")
    public static Listbox lstSubDepartment;
    
    
    //Create Button for Close Add Employee Window
    @FindBy(name = "button")
    public static Button btnClose;
    
    //Create Button for Create Employee
    @FindBy(name = "commit")
    public static Button btnCreate;
}	
