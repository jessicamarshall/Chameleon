package org.selophane.elements;

import org.selophane.elements.impl.TextboxImpl;
import org.selophane.elements.impl.internal.ImplementedBy;

/**
 * Text field functionality.
 */
@ImplementedBy(TextboxImpl.class)
public interface Textbox extends Element {
    /**
     * @param text The text to type into the field.
     */
    void set(String text);
}