/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class DocumentSizeFilter extends DocumentFilter {
    int maxLength;
 
    public DocumentSizeFilter(int maxLength) {
        this.maxLength = maxLength;
    }
 
    @Override
    public void insertString(FilterBypass fb, int offs,
                             String str, AttributeSet a)
        throws BadLocationException {
        
        if ((fb.getDocument().getLength() + str.length()) <= maxLength)
            super.insertString(fb, offs, str, a);
    }
     
    @Override
    public void replace(FilterBypass fb, int offs,
                        int length, 
                        String str, AttributeSet a)
        throws BadLocationException {

        if ((fb.getDocument().getLength() + str.length()
             - length) <= maxLength)
            super.replace(fb, offs, length, str, a);
    }
 
}
