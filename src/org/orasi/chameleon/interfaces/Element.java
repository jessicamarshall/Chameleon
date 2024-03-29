package org.orasi.chameleon.interfaces;

import org.orasi.chameleon.interfaces.impl.internal.ImplementedBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.internal.WrapsElement;
import org.orasi.chameleon.interfaces.impl.ElementImpl;

/**
 * wraps a web element interface with extra functionality. Anything added here will be added to all descendants.
 */
@ImplementedBy(ElementImpl.class)
public interface Element extends WebElement, WrapsElement, Locatable {
    /**
     * Returns true when the inner element is ready to be used.
     *
     * @return boolean true for an initialized WebElement, or false if we were somehow passed a null WebElement.
     */
    boolean elementWired();
    void syncVisible(WebDriver driver, String timeout, boolean returnError);
    void syncHidden(WebDriver driver,String timeout, boolean returnError);
    String getElementLocator();
    String getElementIdentifier();
}