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

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author dany
 */
public class ImageUtil {

    public ImageUtil() {
    }

    public static BufferedImage convertBufferdImage(Image image) {
        int width = image.getWidth(null);
        int height = image.getHeight(null);

        BufferedImage result = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        Graphics2D gd = result.createGraphics();
        gd.drawImage(image, 0, 0, null);
        gd.dispose();
        return result;
    }
}
