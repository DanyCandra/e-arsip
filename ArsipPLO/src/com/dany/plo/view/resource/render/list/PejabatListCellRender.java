/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dany.plo.view.resource.render.list;

import com.dany.plo.model.LantaiModel;
import com.dany.plo.model.PejabatModel;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;

/**
 *
 * @author Dany Candra
 */
public class PejabatListCellRender extends DefaultListCellRenderer {

    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus); //To change body of generated methods, choose Tools | Templates.
        if (value instanceof PejabatModel) {
            PejabatModel model=(PejabatModel) value;
            String text=model.getNamaPejabat();
            
            label.setText(text);
        }
        return label;
    }

}
