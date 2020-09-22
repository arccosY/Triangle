package com.company;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Render {

    public static void renderTriangle(BufferedImage img, int x1, int y1, int x2, int y2, int x3, int y3) {
        for (int i = 0; i < img.getWidth(); i++) {
            for (int j = 0; j < img.getHeight(); j++) {
                double A = (x1 - i) * (y2 - y1) - (x2 - x1) * (y1 - j);
                double B = (x2 - i) * (y3 - y2) - (x3 - x2) * (y2 - j);
                double C = (x3 - i) * (y1 - y3) - (x1 - x3) * (y3 - j);
                if (Math.signum(A) == Math.signum(B) && Math.signum(B) == Math.signum(C)){
                    int a = (int)(Math.random() * (0 - 218 + 1) + 218);
                    int b = (int)(Math.random() * (0 - 218 + 1) + 218);
                    int c = (int)(Math.random() * (0 - 218 + 1) + 218);
                    img.setRGB(i, j, new Color(a, b, c).getRGB());
                }
                if ((A == 0) && (B == 0) && (C == 0)) {
                    int a = (int)(Math.random() * (0 - 218 + 1) + 218);
                    int b = (int)(Math.random() * (0 - 218 + 1) + 218);
                    int c = (int)(Math.random() * (0 - 218 + 1) + 218);
                    img.setRGB(i, j, new Color(a, b, c).getRGB());
                }
            }
        }
    }


    //Стоит начать с этого
    public static void renderLine(BufferedImage img, int x1, int y1, int x2, int y2, int color) {
        if (x1 > x2) {
            if (y1 > y2) {
                if ((x1 - x2) > (y1 - y2)) {
                    for (int i = x2; i < x1; i++) {
                        int y = ((x1 - i) * (y1 - y2) / (x1 - x2) + y1);
                        img.setRGB(i, y, Color.BLACK.getRGB());
                    }
                } else {
                    for (int i = y2; i < y1; i++) {
                        int x = ((y1 - i) * (x1 - x2)) / (y1 - y2) + x1;
                        img.setRGB(x, i, Color.BLACK.getRGB());
                    }

                }
            } else {
                if ((x1 - x2) > (y2 - y1)) {
                    for (int i = x2; i < x1; i++) {
                        int y = ((x1 - i) * (y1 - y2) / (x1 - x2) + y1);
                        img.setRGB(i, y, Color.BLACK.getRGB());
                    }
                } else {
                    for (int i = y1; i < y2; i++) {
                        int x = ((y1 - i) * (x2 - x1)) / (y1 - y2) + x1;
                        img.setRGB(x, i, Color.BLACK.getRGB());
                    }
                }
            }
        } else if (y2 > y1) {
            if ((x2 - x1) > (y2 - y1)) {
                for (int i = x1; i < x2; i++) {
                    int y = (i - x1) * (y2 - y1) / (x1 - x2) + y1;
                    img.setRGB(i, y, Color.BLACK.getRGB());
                }
            } else {
                for (int i = y1; i < y2; i++) {
                    int x = ((y1 - i) * (x2 - x1)) / (y1 - y2) + x1;
                    img.setRGB(x, i, Color.BLACK.getRGB());
                }
            }
        } else if ((x2 - x1) > (y1 - y2)) {
            for (int i = x1; i < x2; i++) {
                int y = ((x1 - i) * (y1 - y2) / (x1 - x2) + y1);
                img.setRGB(i, y, Color.BLACK.getRGB());
            }
        } else {
            for (int i = y2; i < y1; i++) {
                int x = ((y1 - i) * (x1 - x2)) / (y1 - y2) + x1;
                img.setRGB(x, i, Color.BLACK.getRGB());

            }
        }
    }
}



