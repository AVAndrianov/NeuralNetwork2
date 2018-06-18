package com.avandrianov;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static List<Neuron> neuronsMass;
    static MemorySet memorySet;
    static BufferedReader br;
    static CreateImage createimage;
    static InputSet inputSet;
    static Map<String, Integer> characterPlace;
    static Comparison comparison;
    static PrintNeuron printNeuron;
    static int weight;
    static int test = 0;
    static int verificationThreshold = 0;
    static char neuronCoincidence = '=';
    static String character;
    static int w;


    public static void main(String[] args) {
        createNeurons();
//        createNeuronsImage();
        while (true) {
            w = -10000;
            weight = -10000;
            loadingNeurons();
            trainingNeurons();
            outputOnDisplay();
            comparison.zeroingOutTest();
        }
    }


    private static void createNeurons() {
        memorySet = new MemorySet();
        neuronsMass = new ArrayList<>(33);
        for (int i = 0; i < 32; i++) {
            Neuron neuron = new Neuron((char) ((int) 'А' + i), 0);
            neuronsMass.add(neuron);

        }
    }

    private static void createNeuronsImage() {
        for (int i = 0; i < 32; i++) {
            createimage = new CreateImage();
            createimage.createImage(neuronsMass.get(i));
        }

    }

    private static void loadingNeurons() {
        for (int i = 0; i < 32; i++) {
            try {
                memorySet.memorySet(neuronsMass.get(i));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void trainingNeurons() {
        inputSet = new InputSet();
        characterPlace = new HashMap<>();
        comparison = new Comparison(neuronsMass, inputSet.inputSet());

        for (int i = 0; i < neuronsMass.size(); i++) {
            characterPlace.put(String.valueOf(neuronsMass.get(i).getName()), i);
            w = comparison.comparison(i);
            System.out.println(w + "  " + comparison.getVerificationThreshold()+ " "
                    + neuronsMass.get(i).getName());
            if (w > weight) {
                weight = w;
                verificationThreshold = comparison.getVerificationThreshold();
                neuronCoincidence = neuronsMass.get(i).getName();
            }
            comparison.zeroingOutWeight();
        }


    }

    private static void outputOnDisplay() {
        printNeuron = new PrintNeuron();
        br = new BufferedReader(new InputStreamReader(System.in));
        if (verificationThreshold > 50) {
            printNeuron.printNeuron(neuronsMass.get(characterPlace.get(String.valueOf(neuronCoincidence))));

            System.out.print("Совпадение менее 30%, " +
                    "введите значение которое является правельным: ");

            try {
                character = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            NeuronTraining neuronTraining = new NeuronTraining(
                    neuronsMass.get(characterPlace.get(character))
                    , comparison.getInput()
                    , characterPlace);
            neuronTraining.training();
        } else {
            printNeuron.printNeuron(neuronsMass.get(characterPlace.get(String.valueOf(neuronCoincidence))));

            System.out.println("Это буква: " + neuronCoincidence);
            System.out.println("Weight: " + weight + "VerificationThreshold: "
                    + -verificationThreshold);
            System.out.println(test);

        }
    }


}
