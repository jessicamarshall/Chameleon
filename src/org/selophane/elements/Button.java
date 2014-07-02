package org.selophane.elements;

import org.selophane.elements.impl.ButtonImpl;
import org.selophane.elements.impl.internal.ImplementedBy;

/**
 * Interface that wraps a WebElement in Button functionality. 
 */
@ImplementedBy(ButtonImpl.class)
public interface Button extends Element {

}