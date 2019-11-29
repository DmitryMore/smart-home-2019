package ru.sbt.mipt.oop.sensor;

import ru.sbt.mipt.oop.EventGenerator;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.eventProcessors.DoorEventProcessor;
import ru.sbt.mipt.oop.eventProcessors.EventProcessor;
import ru.sbt.mipt.oop.eventProcessors.LightEventProcessor;

public class SensorEventHandler {
    private final SmartHome smartHome;
    private EventProcessor eventProcessor;

    public SensorEventHandler(SmartHome smartHome) {
        this.smartHome = smartHome;
        this.eventProcessor = null;
    }

    public void run(){
        SensorEvent event = EventGenerator.generateSensorEvent();
        while (event != null){
            this.processEvent(event);
            event = EventGenerator.generateSensorEvent();
        }
    }

    public void processEvent(SensorEvent event) {
        System.out.println("Got event: " + event);
        new LightEventProcessor(smartHome, event).processEvent();
        new DoorEventProcessor(smartHome, event).processEvent();
    }
}
