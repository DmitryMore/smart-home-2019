package ru.sbt.mipt.oop.adapters;

import com.coolcompany.smarthome.events.CCSensorEvent;
import ru.sbt.mipt.oop.sensor.SensorEvent;

public interface CCSensorEventAdapter {
    SensorEvent convert(CCSensorEvent ccSensorEvent);
}
