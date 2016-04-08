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

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author dany
 */
public final class IconReflectionUtil {

    private IconReflectionUtil() {
    }


    public static BufferedImage createReflection(BufferedImage image) {
        BufferedImage result = new BufferedImage(image.getWidth(), image.getHeight() * 6 / 4, BufferedImage.TYPE_INT_ARGB);
        Graphics2D gd = result.createGraphics();

        //penggambaran icon asli
        gd.drawImage(image, 0, 0, null);

        //point refleksi
        gd.scale(1.0, -1.0);
        gd.drawImage(image, 0, -image.getHeight() * 2, null);
        gd.scale(1.0, -1.0);

        //move mirror
        gd.translate(0, image.getHeight());

        //pembuatan gradient
        GradientPaint mask = new GradientPaint(0, 0, new Color(1f, 1f, 1f, 0.5f), 0, image.getHeight() / 2, new Color(1f, 1f, 1f, 0f));
        gd.setPaint(mask);

        //set alpha composite
        gd.setComposite(AlphaComposite.DstIn);

        //penggambaran
        gd.fillRect(0, 0, image.getWidth(), image.getHeight());

        gd.dispose();

        return result;
    }

    public static BufferedImage cretaeReflection(Image image) {
        return createReflection(ImageUtil.convertBufferdImage(image));
    }
}
