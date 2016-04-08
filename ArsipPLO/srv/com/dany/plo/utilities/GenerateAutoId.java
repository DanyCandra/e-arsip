/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dany.plo.utilities;

/**
 *
 * @author Dany Candra
 */
public class GenerateAutoId {

    public static String generateAutoId() {
        String id = "";

        long longId = System.currentTimeMillis();

        id = String.valueOf(longId);

        return id;
    }

}
