package com.study.epamproject.domain;

public class Computer extends ElectronicToy {
    private final VideoCard videoCardModel;
    private final Processor processor;

    public Computer(String name, Integer price, Manufacturer manufacturer, long ramSize, VideoCard videoCardModel, Processor processor) {
        super(name, price, manufacturer, ramSize);
        this.videoCardModel = videoCardModel;
        this.processor = processor;
    }

    public VideoCard getVideoCardModel() {
        return videoCardModel;
    }

    public Processor getProcessor() {
        return processor;
    }
}
