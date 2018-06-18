package com.avandrianov;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class NeuronTraining {
    Neuron neuron;
    List<List<Integer>> input;
    List<List<Integer>> memory;
    Map<String, Integer> characterPlace;
    BufferedImage bufferedImage;
    File image;
    String fileSeparator;
    String absoluteFilePath;


    public NeuronTraining(Neuron neuron, List<List<Integer>> input, Map<String, Integer> characterPlace) {
        this.neuron = neuron;
        this.input = input;
        this.characterPlace = characterPlace;
    }

    public void training() {
        fileSeparator = System.getProperty("file.separator");
        absoluteFilePath = "res" + fileSeparator + neuron.getName() + ".png";
        bufferedImage = new BufferedImage(30, 30, BufferedImage.TYPE_INT_ARGB);
        try {
            bufferedImage = ImageIO.read(new File(absoluteFilePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        memory = neuron.getMemory();
        for (int i = 0; i <= 29; i++) {
            for (int j = 0; j < 29; j++) {
//                int mem = memory.get(i).get(j);
                int inp = input.get(i).get(j);
                int pixelWeith = bufferedImage.getRGB(i, j);
                int newWeith = inp + pixelWeith;
                if (newWeith > -16000000)
                    bufferedImage.setRGB(i, j, newWeith);
                else
                    bufferedImage.setRGB(i, j, -16000000);
            }
        }
        try {
            ImageIO.write(bufferedImage,"png",new File(absoluteFilePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
