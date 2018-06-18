package com.avandrianov;

import java.util.List;

public class PrintNeuron {

    List<List<Integer>> memory;

    public void printNeuron(Neuron neuron) {
        memory = neuron.getMemory();
        for (int i = 0; i <= 29; i++) {
            System.out.println(memory.get(i));

        }
    }

}
