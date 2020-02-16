package ru.sbt.mipt.oop.eventProcessors;

import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.sensor.SensorEvent;

public interface EventProcessor {
    void processEvent(SmartHome smartHome, SensorEvent sensorEvent);
}
