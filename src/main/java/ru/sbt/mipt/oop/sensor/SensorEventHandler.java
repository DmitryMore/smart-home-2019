package ru.sbt.mipt.oop.sensor;

import ru.sbt.mipt.oop.EventGenerator;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.eventProcessors.DoorEventProcessor;
import ru.sbt.mipt.oop.eventProcessors.LightEventProcessor;

public class SensorEventHandler {
    private final SmartHome smartHome;

    public SensorEventHandler(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    public void run(){
        while (true){
            SensorEvent event = EventGenerator.generateSensorEvent();
            if (event == null) return;
            this.processEvent(event);
        }
    }

    public void processEvent(SensorEvent event) {
        System.out.println("Got event: " + event);
        new LightEventProcessor(smartHome, event).processEvent();
        new DoorEventProcessor(smartHome, event).processEvent();
    }
}
