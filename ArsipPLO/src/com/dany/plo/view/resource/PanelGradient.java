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

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JPanel;

/**
 *
 * @author Dyca
 */
public class PanelGradient extends JPanel {

    private Color colorTop;
    private Color colorBottom;
    private boolean round;
    private double roundSize;
    private boolean frame;
    private float frameSize;
    private Color colorFrame;
    private Shape shape, shapeRound;

    public float getFrameSize() {
        return frameSize;
    }

    public void setFrameSize(float frameSize) {
        this.frameSize = frameSize;
        repaint();
    }

    public Color getColorFrame() {
        return colorFrame;
    }

    public void setColorFrame(Color colorFrame) {
        this.colorFrame = colorFrame;
        repaint();
    }

    public boolean isFrame() {
        return frame;
    }

    public void setFrame(boolean frame) {
        this.frame = frame;
        repaint();
    }

    public Color getColorBottom() {
        return colorBottom;
    }

    public void setColorBottom(Color colorBottom) {
        this.colorBottom = colorBottom;
        repaint();
    }

    public Color getColorTop() {
        return colorTop;
    }

    public void setColorTop(Color colorTop) {
        this.colorTop = colorTop;
        repaint();
    }

    public boolean isRound() {
        return round;
    }

    public void setRound(boolean round) {
        this.round = round;
        repaint();
    }

    public double getRoundSize() {
        return roundSize;
    }

    public void setRoundSize(double roundSize) {
        this.roundSize = roundSize;
        repaint();
    }

    public PanelGradient() {
        setOpaque(false);
        setColorBottom(Color.MAGENTA);
        setColorTop(Color.BLACK);
        setRound(false);
        setRoundSize(15);
        setFrame(false);
        setColorFrame(Color.YELLOW);
        setFrameSize(3F);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D gd = (Graphics2D) g.create();
        gd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint paint = new GradientPaint(0, 0, getColorTop(), 0, getHeight(), getColorBottom());
        gd.setPaint(paint);
        gd.setStroke(new BasicStroke(getFrameSize()));
        if (isRound()) {
            shape = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), getRoundSize(), getRoundSize());
            gd.fill(shape);
            if (isFrame()) {
                shapeRound = new RoundRectangle2D.Double(0, 0, getWidth() - 1, getHeight() - 1, getRoundSize(), getRoundSize());
                gd.setColor(getColorFrame());
                gd.draw(shapeRound);
            } else {
                return;
            }
        } else {
            shape = new Rectangle2D.Double(0, 0, getWidth(), getHeight());
            gd.fill(shape);
            if (isFrame()) {
                shapeRound = new Rectangle2D.Double(0, 0, getWidth() - 1, getHeight() - 1);
                gd.setColor(getColorFrame());
                gd.draw(shapeRound);
            } else {
                return;
            }
        }
        gd.dispose();
    }
}
