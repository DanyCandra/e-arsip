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
public class ValidatorNumber {

    public static boolean isNumber(String value, Component component, String komponenError) {
        boolean result = false;

        double tmpNumber;

        if (!value.equals("")) {
            try {
                tmpNumber = Double.parseDouble(value);
                result = true;
            } catch (NumberFormatException exception) {
                JOptionPane.showMessageDialog(component, komponenError+ " Harus Dalam Angka ", "Pesan Kesalahan", JOptionPane.ERROR_MESSAGE);
            }
        }
        return result;
    }

}
