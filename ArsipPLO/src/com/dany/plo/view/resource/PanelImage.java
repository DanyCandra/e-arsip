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


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author dany
 */
public class PanelImage extends JPanel {

    private Image image;
    private Icon imageBackground;

    public PanelImage() {
        setOpaque(false);
        setImageBackground(imageBackground);

    }

    public Icon getImageBackground() {
        return imageBackground;
    }

    public void setImageBackground(Icon imageBackground) {
        try {
            if (imageBackground == null) {
                firePropertyChange("iconBackground", getImageBackground(), imageBackground);
                this.imageBackground = imageBackground;
            } else {
                if (!(imageBackground instanceof ImageIcon)) {
                    throw new IllegalArgumentException();
                }
                firePropertyChange("iconBackground", getImageBackground(), imageBackground);
                this.imageBackground = imageBackground;
                ImageIcon icon = (ImageIcon) imageBackground;
                BufferedImage image = ImageUtil.convertBufferdImage(icon.getImage());
                this.image = image;
            }
        } catch (IllegalArgumentException e) {
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D gd = (Graphics2D) g.create();
        
        gd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        gd.drawImage(image, 0, 0, getWidth(), getHeight(), null);

        gd.dispose();
    }
}
