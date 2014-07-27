package org.orasi.blueSource.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.orasi.chameleon.interfaces.*;
import org.orasi.chameleon.interfaces.impl.internal.ElementFactory;

public class blueSourceHomepage {
	private static WebDriver driver;

	public blueSourceHomepage(WebDriver driver){
		blueSourceHomepage.driver = driver;	
		ElementFactory.initElements(driver, this);	  
	}
	
	public static blueSourceHomepage initialize() {
        return ElementFactory.initElements(driver, blueSourceHomepage.class);	        
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
    
	/*
	 * used as the BlueSource Homepage loads. Will wait until the
	 * WebTable has finished loading before exiting the function
	 * 
	 * @param driver the main WebDriver object for your browser 
	 * 
	 * @see org.orasi.chameleon.blueSource.resources.blueSourceHomepage.blueSourceHomepagePage.blueSourceHomepagePage#tblEmployees
	 * 
	 * @author Justin.Phlegar@orasi.com 7/7/2014
	 */
	public void waitUntilEmployeeTableLoads()
	{
		initialize();
		tblEmployees.syncVisible(driver, "DEFAULT", true);
	}
	

	/*
	 * Testing Webtable functionality
	 */
	public void testWebtableObjects(){
		initialize();

		System.out.println("Get Row Count: " + tblEmployees.getRowCount());
		
		System.out.println("Get Column Count: " + tblEmployees.getColumnCount(driver, 1));			
	
		System.out.println("Get Row number with Cell Text 'Otherthomas': " + tblEmployees.getRowWithCellText(driver,"Otherthomas"));			
		
		System.out.println("Get Row number with Cell Text 'Gonzalez' in Column 2 and starting at row 15: " +tblEmployees.getRowWithCellText(driver, "Gonzalez",2,15));
		
		System.out.println("Get Column number with Cell Text 'Last Name': " + tblEmployees.getColumnWithCellText(driver,"Last Name"));
		;
		System.out.println("Get Row number with Cell Text 'Dargatz' and Column Header 'Last Name': " + tblEmployees.getRowWithCellText(driver,"Dargatz", 
							tblEmployees.getColumnWithCellText(driver,"Last Name")));
		
		System.out.println("Get Cell Data for 10,2: " + tblEmployees.getCellData(driver, 10, 2));
		
		System.out.println("Get Column number with Cell Text 'Location' : " + tblEmployees.getColumnWithCellText(driver,"Location"));
	}
	
	/*
	 * Goes through the process of adding an employee
	 */
	public void addEmployee(){
        //Build Page Object Repository
		initialize();
		
		waitUntilEmployeeTableLoads();
		
		//Click to open Add Employees to Directory Window
		btnDirectoryAdd.click();
		
		// Add Employee Data
		txtUserName.set("Testuser234235");
		
		txtFirstName.set("Testuser");
		
		txtLastName.set("234235");
		
		lstTitle.select("Consultant");
		
		lstRole.select("Base");
		
		lstManager.select("Jim Azar");
		
		txtBridgeTime.set("1");
		
		lstLocation.select("Remote");
		
		txtStartDate.set("2012-11-11");
		
		txtCellPhone.set("3363363366");
		
		txtOfficePhone.set("3366633366");
		
		txtEmail.set("test@test.com");
		
		txtIMName.set("Testuser2345645");
		
		lstIMClient.select("Skype");
		
	/*	lstMainDepartment.select(strMainDepartment);
		
		if (strMainDepartment.toString() == "Services") {
			
			blueSourceHomepagePage.lstServicesDepartment.select(strServicesDepartment);
			
			if (strServicesDepartment.toString() == "Rural") {
				
				blueSourceHomepagePage.lstSubDepartment.select("BlueSource® Team");
			}	
		}		*/
		
		//Click Create to commit data
		blueSourceHomepage.btnCreate.click();
				
	}

}	
