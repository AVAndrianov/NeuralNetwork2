package com.avandrianov;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MemorySet {
    char neuronName;
    Neuron neuron;
    List<List<Integer>> memory;
    BufferedImage bufferedImage;

    public MemorySet() {

    }

    public void memorySet(Neuron neuron) throws IOException {
        this.neuron = neuron;
        this.neuronName = neuron.getName();
        bufferedImage = new BufferedImage(30,30, BufferedImage.TYPE_INT_ARGB);
        bufferedImage = ImageIO.read(new File("res/" + neuronName + ".png"));
        memory = new ArrayList<>(30);
        for (int i = 0; i <= 29; i++) {
            memory.add(new ArrayList<>(30));
        }
        for (int i = 0; i <=29 ; i++) {
            for (int j = 0; j <= 29; j++) {
                memory.get(i).add(bufferedImage.getRGB(i,j));
            }
        }

        neuron.setMemory(memory);

    }
}
