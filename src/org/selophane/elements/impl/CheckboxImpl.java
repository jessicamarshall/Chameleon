package org.selophane.elements.impl;

import org.selophane.elements.Checkbox;
import org.openqa.selenium.WebElement;

/**
 * Wrapper class like Select that wraps basic checkbox functionality.
 */
public class CheckboxImpl extends ElementImpl implements Checkbox {

    /**
     * Wraps a WebElement with checkbox functionality.
     *
     * @param element to wrap up
     */
    public CheckboxImpl(WebElement element) {
        super(element);
    }

    public void toggle() {
        getWrappedElement().click();
    }

    public void check() {
        if (!isChecked()) {
            toggle();
        }
    }

    public void uncheck() {
        if (isChecked()) {
            toggle();
        }
    }

    public boolean isChecked() {
        return getWrappedElement().isSelected();
    }
}