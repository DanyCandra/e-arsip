/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dany.plo.test;

import com.dany.plo.exception.ArsipException;
import com.dany.plo.model.PengarsipanModel;
import java.util.List;

/**
 *
 * @author Dany Candra
 */
public class Testaja {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ArsipException {
        PengarsipanModel model = new PengarsipanModel();
        List<PengarsipanModel> list = model.getDaftarBerkasTersedia(0, 100);
        for (PengarsipanModel pengarsipanModel : list) {
            System.out.println(pengarsipanModel.getIdArsip());
            System.out.println(pengarsipanModel.getDebiturModel().getCif());
            System.out.println(pengarsipanModel.getTanggalTerima());
            System.out.println(pengarsipanModel.getUserPenerima().getIdUser());
            System.out.println(pengarsipanModel.getStatusArsip());
        }

    }

}
