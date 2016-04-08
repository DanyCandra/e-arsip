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
public class ValidatorNotNull {

    public static boolean isNotNull(String value, Component component,String komponenError) {
        boolean result = false;
        if (value.trim().equals("")) {
            JOptionPane.showMessageDialog(component, komponenError+" Tidak Boleh Kosong", "Pesan Kesalahan", JOptionPane.ERROR_MESSAGE);
            result = false;
        } else {
            result = true;
        }
        return result;
    }

}
