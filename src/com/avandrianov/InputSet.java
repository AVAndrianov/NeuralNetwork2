package com.avandrianov;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class InputSet {

    BufferedImage bufferedImage;
    List<List<Integer>> input;


    public List<List<Integer>> inputSet() {
        LoadFile loadFile = new LoadFile();
        bufferedImage = loadFile.loadFile();
        input = new ArrayList<>(30);
        for (int i = 0; i <= 29; i++) {
            input.add(new ArrayList<>(30));
        }

        for (int i = 0; i <= 29; i++) {
            for (int j = 0; j <= 29; j++) {
                input.get(i).add(bufferedImage.getRGB(i, j));
            }
        }
        for (int j = 0; j <= 29; j++) {

            System.out.println(input.get(j));
        }
        return input;

    }
}
