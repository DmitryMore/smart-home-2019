package ru.sbt.mipt.oop.eventProcessors;

import ru.sbt.mipt.oop.Door;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.sensor.SensorEvent;

import static ru.sbt.mipt.oop.sensor.SensorEventType.DOOR_CLOSED;
import static ru.sbt.mipt.oop.sensor.SensorEventType.DOOR_OPEN;

public class DoorEventProcessor implements EventProcessor {

    public DoorEventProcessor() {}

    @Override
    public void processEvent(SmartHome smartHome, SensorEvent sensorEvent) {
        smartHome.execute(object -> {
            if (!(object instanceof Door)) return;
            Door door = (Door) object;
            changeState(door, sensorEvent);
        });
    }

    private void changeState(Door door, SensorEvent sensorEvent) {
        if (sensorEvent.getType() == DOOR_OPEN){
            door.setOpen(true);
            System.out.println("Door " + door.getId() + " was opened.");
        }
        if (sensorEvent.getType() == DOOR_CLOSED){
            door.setOpen(false);
            System.out.println("Door " + door.getId() + " was closed.");
        }
    }
}
