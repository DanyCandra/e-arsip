/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dany.plo.view.resource.render.list;

import com.dany.plo.model.InstansiModel;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Dany Candra
 */
public class InstansiComboBoxModel extends DefaultComboBoxModel<InstansiModel> {

    public InstansiComboBoxModel() {
        super();
    }

    @Override
    public Object getSelectedItem() {
        InstansiModel model = (InstansiModel) super.getSelectedItem();
        return model;
    }

}
