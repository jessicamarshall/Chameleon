package org.orasi.chameleon.interfaces;

import org.orasi.chameleon.interfaces.impl.ButtonImpl;
import org.orasi.chameleon.interfaces.impl.internal.ImplementedBy;

/**
 * Interface that wraps a WebElement in Button functionality. 
 */
@ImplementedBy(ButtonImpl.class)
public interface Button extends Element {

}