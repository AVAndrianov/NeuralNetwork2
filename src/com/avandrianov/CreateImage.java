package com.avandrianov;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CreateImage {
    private char name;
    private Neuron neuron;
    private String fileSeparator;
    private String absoluteFilePath;
    private BufferedImage bufferedImage;
    private File image;
    private Graphics g;
    private List<List<Integer>> listMass;


    public void createImage(Neuron neuron) {
        listMass = new ArrayList<>(30);
        for (int i = 0; i <= 29; i++) {
            listMass.add(new ArrayList<>(30));
        }
        this.listMass = neuron.getMemory();
        this.neuron = neuron;
        this.name = neuron.getName();
        fileSeparator = System.getProperty("file.separator");
        absoluteFilePath = "res" + fileSeparator + name + ".png";

        bufferedImage = new BufferedImage(30, 30,
                BufferedImage.TYPE_INT_ARGB);

        image = new File(absoluteFilePath);

        g = bufferedImage.getGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 30, 30);

        try {
            ImageIO.write(bufferedImage, "PNG", image);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BufferedImage getBufimage() {
        return bufferedImage;
    }
    public void updateImage(){
        for (int i = 0; i <= 29; i++) {
            for (int j = 0; j <= 29; j++) {
                bufferedImage.setRGB(i, j, listMass.get(i).get(j) * -10);

            }

        }
    }
}
