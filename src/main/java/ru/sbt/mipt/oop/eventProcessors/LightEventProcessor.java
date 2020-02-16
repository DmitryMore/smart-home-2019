package ru.sbt.mipt.oop.eventProcessors;

import ru.sbt.mipt.oop.Light;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.sensor.SensorEvent;

import static ru.sbt.mipt.oop.sensor.SensorEventType.*;

public class LightEventProcessor implements EventProcessor{

    public LightEventProcessor() {}

    public void processEvent(SmartHome smartHome, SensorEvent sensorEvent) {
        smartHome.execute(object -> {
            if (!(object instanceof Light)) return;
            Light light = (Light) object;
            changeState(light, sensorEvent);
        });
    }

    private void changeState(Light light, SensorEvent sensorEvent) {
        if (sensorEvent.getObjectId().equals(light.getId())) {
            if (sensorEvent.getType() == LIGHT_ON) {
                light.setOn(true);
                System.out.println("Light " + light.getId() + " was turned on.");
            }
            if (sensorEvent.getType() == LIGHT_OFF) {
                light.setOn(false);
                System.out.println("Light " + light.getId() + " was turned off.");
            }
        }
    }
}
