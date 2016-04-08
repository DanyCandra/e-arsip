/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dany.plo.view.validator;

import java.awt.Component;
import javax.swing.JComponent;
import javax.swing.JOptionPane;

/**
 *
 * @author Dany Candra
 */
public class ValidatorTextLimit {

    public static boolean isLimit(String value, int limit, Component component) {
        boolean result = false;

        double tmpNumber;

        if (!value.equals("")) {
            if (value.length() > limit) {
                result = false;
                JOptionPane.showMessageDialog(component, "Panjang karakter maksimal " + limit + " karakter", "Pesan Kesalahan", JOptionPane.ERROR_MESSAGE);
            } else {
                result = true;
            }
        }
        return result;
    }

}
