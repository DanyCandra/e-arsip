/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dany.plo.view.resource;

import java.util.EventListener;

/**
 *
 * @author Dany Candra
 */
public interface CrudListener extends EventListener {

    void tambah(CrudEvent event);

    void ubah(CrudEvent event);

    void hapus(CrudEvent event);

    void segarkan(CrudEvent event);

}
