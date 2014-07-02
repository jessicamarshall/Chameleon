package org.selophane.elements;

import org.openqa.selenium.WebElement;
import org.selophane.elements.impl.ListboxImpl;
import org.selophane.elements.impl.internal.ImplementedBy;

import java.util.List;

/**
 * Interface for a select element.
 */
@ImplementedBy(ListboxImpl.class)
public interface Listbox extends Element {


    /**
     * Wraps Selenium's method.
     *
     * @param value the value to select.
     * @see org.openqa.selenium.support.ui.Select#selectByVisibleText(String)
     */
    void select(String value);


    /**
     * Wraps Selenium's method.
     *
     * @see org.openqa.selenium.support.ui.Select#deselectAll()
     */
    void deselectAll();


    /**
     * Wraps Selenium's method.
     *
     * @param text text to deselect by visible text
     * @see org.openqa.selenium.support.ui.Select#deselectByVisibleText(String)
     */
    void deselectByVisibleText(String text);
    
    WebElement getFirstSelectedOption();

    List<WebElement> getOptions();

}