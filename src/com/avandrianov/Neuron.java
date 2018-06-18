package com.avandrianov;

import java.util.ArrayList;
import java.util.List;

public class Neuron {
    private char name;
    private int output;
    private List<List<Integer>> input;
    private List<List<Integer>> memory;


    public Neuron(char name, int output) {
        this.name = name;
        this.output = output;
        neuron();

    }

    public void neuron() {
        input = new ArrayList<>(30);
        memory = new ArrayList<>(30);
        for (int i = 0; i <= 29; i++) {
            memory.add(new ArrayList<>(30));
            input.add(new ArrayList<>(30));
        }
    }

    public char getName() {
        return name;
    }

    public int getOutput() {
        return output;
    }

    public List<List<Integer>> getInput() {
        return input;
    }

    public List<List<Integer>> getMemory() {
        return memory;
    }

    public void setOutput(int output) {
        this.output = output;
    }

    public void setInput(List<List<Integer>> input) {
        this.input = input;
    }

    public void setMemory(List<List<Integer>> memory) {
        this.memory = memory;
    }
}
