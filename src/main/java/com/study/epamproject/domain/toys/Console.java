package com.study.epamproject.domain.toys;

public class Console extends Computer {
    private final int consoleGeneration;

    public Console(String name, Integer price, Manufacturer manufacturer, long ramSize, VideoCard videoCardModel, Processor processor, int consoleGeneration) {
        super(name, price, manufacturer, ramSize, videoCardModel, processor);
        this.consoleGeneration = consoleGeneration;
    }

    public int getConsoleGeneration() {
        return consoleGeneration;
    }
}
