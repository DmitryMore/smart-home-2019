package ru.sbt.mipt.oop.adapters;

import com.coolcompany.smarthome.events.CCSensorEvent;
import com.coolcompany.smarthome.events.EventHandler;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.eventProcessors.EventProcessor;
import ru.sbt.mipt.oop.sensor.SensorEvent;

public class EventHandlerAdapter implements EventHandler {
    private EventProcessor eventProcessor;
    private CCSensorEventAdapter ccSensorEventAdapter;
    private SmartHome smartHome;

    public EventHandlerAdapter(EventProcessor eventProcessor, CCSensorEventAdapter ccSensorEventAdapter, SmartHome smartHome) {
        this.eventProcessor = eventProcessor;
        this.ccSensorEventAdapter = ccSensorEventAdapter;
        this.smartHome = smartHome;
    }

    @Override
    public void handleEvent(CCSensorEvent ccSensorEvent) {
        SensorEvent sensorEvent = ccSensorEventAdapter.convert(ccSensorEvent);
        eventProcessor.processEvent(smartHome, sensorEvent);
    }
}
