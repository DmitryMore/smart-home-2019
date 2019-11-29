package ru.sbt.mipt.oop.eventProcessors;

import ru.sbt.mipt.oop.Light;
import ru.sbt.mipt.oop.Room;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.sensor.SensorEvent;

import static ru.sbt.mipt.oop.sensor.SensorEventType.*;
import static ru.sbt.mipt.oop.sensor.SensorEventType.DOOR_CLOSED;

public class LightEventProcessor implements EventProcessor{
    private final SmartHome smartHome;
    private final SensorEvent sensorEvent;

    public LightEventProcessor(SmartHome smartHome, SensorEvent sensorEvent) {
        this.smartHome = smartHome;
        this.sensorEvent = sensorEvent;
    }

    @Override
    public boolean isRightEvent() {
        return (sensorEvent.getType() == LIGHT_ON || sensorEvent.getType() == LIGHT_OFF);
    }

    @Override
    public void processEvent() {
        if (isRightEvent()) {
            for (Room room : smartHome.getRooms()) {
                for (Light light : room.getLights()) {
                    if (light.getId().equals(sensorEvent.getObjectId())) {
                        if (sensorEvent.getType() == LIGHT_ON) {
                            light.setOn(true);
                            System.out.println("Light " + light.getId() + " in room " + room.getName() + " was turned on.");
                        }
                        if (sensorEvent.getType() == LIGHT_OFF) {
                            light.setOn(false);
                            System.out.println("Light " + light.getId() + " in room " + room.getName() + " was turned off.");
                        }
                    }
                }
            }
        }
    }
}
