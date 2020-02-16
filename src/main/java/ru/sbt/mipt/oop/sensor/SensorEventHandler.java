package ru.sbt.mipt.oop.sensor;

import ru.sbt.mipt.oop.EventGenerator;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.eventProcessors.EventProcessor;
import ru.sbt.mipt.oop.eventProcessors.EventProcessorDecorator;

import java.util.List;

public class SensorEventHandler {
    private final SmartHome smartHome;
    private final List<EventProcessor> eventProcessors;
    private final EventProcessorDecorator eventProcessorDecorator;

    public SensorEventHandler(SmartHome smartHome, List<EventProcessor> eventProcessors) {
        this.smartHome = smartHome;
        this.eventProcessors = eventProcessors;
        this.eventProcessorDecorator = new EventProcessorDecorator(eventProcessors);

    }

    public void run(){
        while (true){
            SensorEvent event = EventGenerator.generateSensorEvent();
            if (event == null) return;
            System.out.println("Got event: " + event);
            eventProcessorDecorator.processEvent(smartHome, event);
            //this.processEvent(event);
        }
    }

    private void processEvent(SensorEvent event) {
        System.out.println("Got event: " + event);
        for (EventProcessor eventProcessor : eventProcessors){
            eventProcessor.processEvent(smartHome, event);
        }
    }
}
