package com.avandrianov;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class LoadFile {
    private String url = "loadfile/";
    private String fileSeparator;
    File image;
    BufferedImage bufferedImage;

    public BufferedImage loadFile() {
//        fileSeparator = System.getProperty("file.separator");
//        url += fileSeparator;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            url = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        bufferedImage = new BufferedImage(30, 30, BufferedImage.TYPE_INT_ARGB);
        try {
            bufferedImage = ImageIO.read(new File("loadfile/" + url + ".png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return bufferedImage;

    }
}
