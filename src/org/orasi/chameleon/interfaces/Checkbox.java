package org.orasi.chameleon.interfaces;

import org.orasi.chameleon.interfaces.impl.CheckboxImpl;
import org.orasi.chameleon.interfaces.impl.internal.ImplementedBy;

/**
 * Interface that wraps a WebElement in CheckBox functionality.
 */
@ImplementedBy(CheckboxImpl.class)
public interface Checkbox extends Element {

    /**
     * Toggle the state of the checkbox.
     */
    void toggle();

    /**
     * Checks checkbox if unchecked.
     */
    void check();

    /**
     * Un-checks checkbox if checked.
     */
    void uncheck();

    /**
     * Check if an element is selected, and return boolean.
     *
     * @return true if check is checked, return false in other case
     */
    boolean isChecked();
}