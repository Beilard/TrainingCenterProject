package com.study.epamproject.domain.toys;

public class Processor {
    private final int generation;
    private final double frequency;

    public Processor(int generation, double frequency) {
        this.generation = generation;
        this.frequency = frequency;
    }

    public int getGeneration() {
        return generation;
    }

    public double getFrequency() {
        return frequency;
    }
}
