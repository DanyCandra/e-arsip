/*
 * ###############################
 * # Corat Coret Mahasiswa Malas #
 * #    Dany Candra Febrianto    #
 * #  danydongkrak.wordpress.com #
 * #=============================#
 * #  Tidak menerima pertanyaan  #
 * #    dalam bentuk apapaun  :D #
 * ###############################
 */
package com.dany.plo.view.resource;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

/**
 *
 * @author dany
 */
public class LabelWhite extends JLabel {

    public LabelWhite() {
        super();
        setForeground(Color.WHITE);
        setFont(getFont().deriveFont(Font.BOLD));
    }
}
