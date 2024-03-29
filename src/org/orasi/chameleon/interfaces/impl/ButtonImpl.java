package org.orasi.chameleon.interfaces.impl;

import org.openqa.selenium.WebElement;
import org.orasi.chameleon.interfaces.Button;

/**
 * Wraps a label on a html form with some behavior.
 */
public class ButtonImpl extends ElementImpl implements Button {

    /**
     * Creates a Element for a given WebElement.
     *
     * @param element element to wrap up
     */
    public ButtonImpl(WebElement element) {
        super(element);
    }

//    @Override
//    public String getFor() {
//        return getWrappedElement().getAttribute("for");
//    }
}