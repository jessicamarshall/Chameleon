package org.orasi.chameleon.interfaces.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.orasi.chameleon.interfaces.Element;
import org.orasi.chameleon.interfaces.Textbox;
import org.orasi.chameleon.utilities.CONSTANTS;

import com.google.common.base.Function;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * An implementation of the Element interface. Delegates its work to an underlying WebElement instance for
 * custom functionality.
 */
public class ElementImpl implements Element {

    private final WebElement element;

    /**
     * Creates a Element for a given WebElement.
     *
     * @param element element to wrap up
     */
    public ElementImpl(final WebElement element) {
        this.element = element;      
    }

    @Override
    public void click() {
        element.click();
    }

    @Override
    public void sendKeys(CharSequence... keysToSend) {    
    	  System.out.println(element);
        element.sendKeys(keysToSend);
    }

    @Override
    public Point getLocation() {
        return element.getLocation();
    }

    @Override
    public void submit() {
        element.submit();
    }

    @Override
    public String getAttribute(String name) {
        return element.getAttribute(name);
    }

    @Override
    public String getCssValue(String propertyName) {
        return element.getCssValue(propertyName);
    }

    @Override
    public Dimension getSize() {
        return element.getSize();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return element.findElements(by);
    }

    @Override
    public String getText() {
        return element.getText();
    }

    @Override
    public String getTagName() {
        return element.getTagName();
    }

    @Override
    public boolean isSelected() {
        return element.isSelected();
    }

    @Override
    public WebElement findElement(By by) {
        return element.findElement(by);
    }

    @Override
    public boolean isEnabled() {
        return element.isEnabled();
    }

    @Override
    public boolean isDisplayed() {
        return element.isDisplayed();
    }

    @Override
    public void clear() {
        throw new NoSuchMethodError("Method clear is only available in the " + Textbox.class.getName() + "class.");
    }

    @Override
    public WebElement getWrappedElement() {
        return element;
    }

//    @Override
//    public Point getLocationOnScreenOnceScrolledIntoView() {
//        return ((Locatable) element).getLocationOnScreenOnceScrolledIntoView();
//    }

    @Override
    public Coordinates getCoordinates() {
        return ((Locatable) element).getCoordinates();
    }

    @Override
    public boolean elementWired() {
        return (element != null);
    }
    
	public void syncVisible(WebDriver driver, String timeout, boolean returnError) {
		boolean found = false;
		double loopTimeout = 0;
		
		if (timeout == "DEFAULT"){
			loopTimeout = CONSTANTS.TIMEOUT*100;
		}else{
			loopTimeout = Integer.valueOf(timeout)*100;
		}
		 
		for(double seconds =0 ; seconds < loopTimeout ; seconds+=1){
			
			if (webElementVisible(driver, element)){
				found = true;
				break;
			}
			try {
				Thread.sleep(10);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
			//	e.printStackTrace();
			}
			 
		}
		
		 if(!found && returnError){
			 System.err.println("Element " + element + " is not availible on the page.");
		 }	
	}	 
	
	public void syncHidden(WebDriver driver,String timeout, boolean returnError){
		boolean found = false;
		long loopTimeout = 0;
		 
		if (timeout == "DEFAULT"){
			loopTimeout = CONSTANTS.TIMEOUT*100;
		}else{
			loopTimeout = Long.valueOf(timeout)*100;
		}
		 
		for(double seconds =0 ; seconds < loopTimeout ; seconds+=1){
			
			if (!webElementVisible(driver, element)){
				found = true;
				break;
			}
			try {
				Thread.sleep(10);
			} catch (Exception e) {
				// TODO Auto-generated catch block
			//	e.printStackTrace();
			}
			 
		}
		
		 if(!found && returnError){
			 System.err.println("Element " + element + " is not availible on the page.");
		 }	
		
		// return found;
	}	 
	 
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	private boolean webElementVisible(WebDriver driver, WebElement element){
		 Wait wait  = new WebDriverWait(driver, 0);		

		 try{		
			 	return wait.until(ExpectedConditions.visibilityOf(element)) != null;		
			}catch (NoSuchElementException |  ClassCastException | StaleElementReferenceException | TimeoutException  e){
				return false;
			}			
 
	 }
	 
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public void isLoaded() throws Error {
	     new FluentWait(element)
	             .withTimeout(60, TimeUnit.SECONDS)
	             .pollingEvery(1, TimeUnit.SECONDS)
	             .ignoring(NoSuchElementException.class)
	             .ignoring(StaleElementReferenceException.class)
	             .until(new Function<WebElement, Boolean>() {
	            
	                 @Override
	                 public Boolean apply(WebElement element) {	                    
	                     return element != null && element.isDisplayed();
	                 }
	             }
	             );
	 }	 
	 
	 public String getElementLocator(){
		 
		 int startPosition = element.toString().lastIndexOf("->") + 3;
		 String locator = element.toString().substring(startPosition, element.toString().lastIndexOf(":"));
		 		 		 
		 return locator.trim();
	 }
	 
	 public String getElementIdentifier(){		
		 int startPosition = element.toString().lastIndexOf(": ")+ 2;
		 String locator = element.toString().substring(startPosition, element.toString().lastIndexOf("]"));
			 
		 return locator.trim();
	 }
}