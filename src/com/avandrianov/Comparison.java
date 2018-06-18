package com.avandrianov;

import java.util.List;

public class Comparison {

    List<Neuron> neuronList;
    List<List<Integer>> input;
    List<List<Integer>> memory;
    int inputPixel;
    int memoryPixel;
    int weight;
    int verificationThreshold;
    int discrepancy;
    int coincidence;
    int test;
    int w;


    public Comparison(List<Neuron> neuronList, List<List<Integer>> input) {
        this.neuronList = neuronList;
        this.input = input;

    }

    public int comparison(int i) {
        memory = neuronList.get(i).getMemory();
        for (int j = 0; j <= 29; j++) {
            for (int k = 0; k <= 29; k++) {
                inputPixel = input.get(j).get(k);
                memoryPixel = memory.get(j).get(k);
                if (memoryPixel < -100 && inputPixel < -100) {
                    w++;
//                    if (memoryPixel < )
                }
                if (memoryPixel > -100 && inputPixel < -100) {
                    verificationThreshold++;
                }
            }
        }
//        for (int j = 0; j <= 29; j++) {
//            for (int k = 0; k <= 29; k++) {
//                inputPixel = input.get(j).get(k);
//                memoryPixel = memory.get(j).get(k);
//                if (memoryPixel == 0 ) test++;
//                if (memoryPixel < -1 && inputPixel == -1) {
//                    discrepancy++;
//                    if (memoryPixel < -8000000) {
//                        discrepancy++;
//                        if (memoryPixel < -16000000) discrepancy++;
//                    }
//                }
//                if (inputPixel < -1 && memoryPixel < -1) {
//                    coincidence++;
//                    if (memoryPixel < -8000000) {
//                        coincidence++;
//                        if (memoryPixel < -16000000) coincidence++;
//                    }
//                }
//            }
//        }
//        verificationThreshold = (coincidence + discrepancy) / 3;
//        int w = coincidence - discrepancy;
//        coincidence = 0;
//        coincidence = 0;
        return w;
    }

    public void zeroingOutWeight() {
        w = 0;
        verificationThreshold = 0;

    }

    public int getVerificationThreshold() {
        return verificationThreshold;
    }

    public int getTest() {
        return test;
    }

    public void zeroingOutTest() {
        test = 0;
    }

    public List<List<Integer>> getInput() {
        return input;
    }
}
