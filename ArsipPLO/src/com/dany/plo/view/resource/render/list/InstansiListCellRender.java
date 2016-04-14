/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dany.plo.view.resource.render.list;

import com.dany.plo.model.InstansiModel;
import com.dany.plo.model.LantaiModel;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;

/**
 *
 * @author Dany Candra
 */
public class InstansiListCellRender extends DefaultListCellRenderer {

    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus); //To change body of generated methods, choose Tools | Templates.
        if (value instanceof InstansiModel) {
            InstansiModel model= (InstansiModel) value;
            String text=model.getNamaInstansi();
            
            label.setText(text);
        }
        return label;
    }

}
