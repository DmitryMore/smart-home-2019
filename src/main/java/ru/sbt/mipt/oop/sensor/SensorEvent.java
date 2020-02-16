package ru.sbt.mipt.oop.sensor;

public interface SensorEvent {
    SensorEventType getType();
    String getObjectId();
}
