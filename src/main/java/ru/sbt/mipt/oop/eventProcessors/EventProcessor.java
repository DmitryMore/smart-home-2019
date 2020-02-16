package ru.sbt.mipt.oop.eventProcessors;

import ru.sbt.mipt.oop.sensor.SensorEvent;

public interface EventProcessor {
    void processEvent();
    boolean isRightEvent();
}
