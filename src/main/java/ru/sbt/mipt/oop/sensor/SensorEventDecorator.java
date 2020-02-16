package ru.sbt.mipt.oop.sensor;

import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.alarm.ActivatedState;
import ru.sbt.mipt.oop.alarm.AlertState;
import ru.sbt.mipt.oop.alarm.HomeAlarm;
import ru.sbt.mipt.oop.eventProcessors.EventProcessor;

import static ru.sbt.mipt.oop.sensor.SensorEventType.*;

import java.util.List;

public class SensorEventDecorator {
    private final List<EventProcessor> eventProcessors;

    public SensorEventDecorator(List<EventProcessor> eventProcessors) {
        this.eventProcessors = eventProcessors;
    }

    public void processEvent(SmartHome smartHome, SensorEvent event) {
        HomeAlarm alarm = smartHome.getAlarm();

        //System.out.println("Got event: " + event);
        if (alarm.getAlarmState() instanceof ActivatedState
                && (event.getType() != ALARM_ACTIVATE || event.getType() != ALARM_DEACTIVATE)){
            System.out.println("Sending SMS...");
            alarm.setToAlert();
        }else if(alarm.getAlarmState() instanceof AlertState && event.getType() != ALARM_DEACTIVATE){
            System.out.println("Sending SMS...");
        }else {
            //System.out.println("Got event: " + event);
            for (EventProcessor eventProcessor : eventProcessors) {
                eventProcessor.processEvent(smartHome, event);
            }
        }
    }
}
