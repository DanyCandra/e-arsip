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


import java.awt.image.BufferedImage;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author dany
 */
public class LabelIconReflection extends LabelWhite {

    private Icon iconReflection;

    public LabelIconReflection() {
        super();
        setHorizontalAlignment(CENTER);
        setHorizontalTextPosition(CENTER);
        setVerticalTextPosition(BOTTOM);
    }

    public Icon getIconReflection() {
        return iconReflection;
    }

    public void setIconReflection(Icon iconReflection) {
        try {
            if (iconReflection == null) {
                firePropertyChange("iconReflection", getIconReflection(), iconReflection);
                this.iconReflection = iconReflection;
                setIcon(iconReflection);
            } else {
                if (!(iconReflection instanceof ImageIcon)) {
                    throw new IllegalArgumentException();
                }
                firePropertyChange("iconReflection", getIconReflection(), iconReflection);
                this.iconReflection = iconReflection;
                BufferedImage image = IconReflectionUtil.cretaeReflection(((ImageIcon) iconReflection).getImage());
                setIcon(new ImageIcon(image));
            }
        } catch (IllegalArgumentException e) {
        }

    }
}
