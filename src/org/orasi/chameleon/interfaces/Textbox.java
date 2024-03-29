package org.orasi.chameleon.interfaces;

import org.orasi.chameleon.interfaces.impl.TextboxImpl;
import org.orasi.chameleon.interfaces.impl.internal.ImplementedBy;

/**
 * Text field functionality.
 */
@ImplementedBy(TextboxImpl.class)
public interface Textbox extends Element {
	/*
	 * 	 * @see org.openqa.selenium.WebElement#clear()
	 */
	public void clear(); 
	
    /**
     * @param text The text to type into the field.
     */
    void set(String text);
    
    /* 
     * @see org.openqa.selenium.WebElement#getText()
     */
    public String getText();
}