package ru.sbt.mipt.oop.sensor;

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

    public void processEvent(SensorEvent event){
        System.out.println("Got event: " + event);
        if (event.getType() == SensorEventType.LIGHT_ON || event.getType() == SensorEventType.LIGHT_OFF){
            eventProcessor = new LightEventProcessor(smartHome);
        }
        if (event.getType() == SensorEventType.DOOR_OPEN || event.getType() == SensorEventType.DOOR_CLOSED){
            eventProcessor = new DoorEventProcessor(smartHome);
        }
        if (eventProcessor != null){
            eventProcessor.processEvent(event);
        }
    }
}
