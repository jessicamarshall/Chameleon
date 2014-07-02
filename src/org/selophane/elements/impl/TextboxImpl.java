package org.selophane.elements.impl;

import org.openqa.selenium.WebElement;
import org.selophane.elements.Textbox;

/**
 * TextInput  wrapper.
 */
public class TextboxImpl extends ElementImpl implements Textbox {
    /**
     * Creates a Element for a given WebElement.
     *
     * @param element element to wrap up
     */
    public TextboxImpl(WebElement element) {
        super(element);
    }

    @Override
    public void clear() {
        getWrappedElement().clear();
    }

    @Override
    public void set(String text) {
        WebElement element = getWrappedElement();
        element.clear();
        element.sendKeys(text);
    }

    /**
     * Gets the value of an input field.
     * @return String with the value of the field.
     */
    @Override
    public String getText() {
        return getWrappedElement().getAttribute("value");
    }
}