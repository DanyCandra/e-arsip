/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dany.plo.view.resource;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

/**
 *
 * @author Dany Candra
 */
public class ShowInternalFrame {

    public static void show(JInternalFrame internalFrame, JDesktopPane desktopPane) {
        if (internalFrame.isVisible() == false) {
            desktopPane.add(internalFrame);
            internalFrame.setVisible(true);

        } else {
            try {
                internalFrame.setIcon(false);
                internalFrame.moveToFront();
            } catch (PropertyVetoException ex) {
                Logger.getLogger(ShowInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public static void makeCenter(JInternalFrame internalFrame) {
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension framesize = internalFrame.getSize();

        if (framesize.height > screensize.height) {
            framesize.height = screensize.height;
        }

        if (framesize.width > screensize.width) {
            framesize.width = screensize.width;
        }

        internalFrame.setLocation((screensize.width - framesize.width) / 2, (screensize.height - framesize.height) / 2);
    }

}
