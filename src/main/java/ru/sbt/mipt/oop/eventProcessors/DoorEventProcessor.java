package ru.sbt.mipt.oop.eventProcessors;

import ru.sbt.mipt.oop.*;
import ru.sbt.mipt.oop.scenario.HallDoorScenario;
import ru.sbt.mipt.oop.sensor.SensorCommand;
import ru.sbt.mipt.oop.sensor.SensorCommandType;
import ru.sbt.mipt.oop.sensor.SensorEvent;

import static ru.sbt.mipt.oop.sensor.SensorEventType.DOOR_CLOSED;
import static ru.sbt.mipt.oop.sensor.SensorEventType.DOOR_OPEN;

public class DoorEventProcessor implements EventProcessor {
    private final SmartHome smartHome;
    private final SensorEvent sensorEvent;

    public DoorEventProcessor(SmartHome smartHome, SensorEvent event) {
        this.smartHome = smartHome;
        this.sensorEvent = event;
    }

    @Override
    public boolean isRightEvent() {
        return (sensorEvent.getType() == DOOR_OPEN || sensorEvent.getType() == DOOR_CLOSED);
    }

    @Override
    public void processEvent() {
        if (isRightEvent()) {
            for (Room room : smartHome.getRooms()) {
                for (Door door : room.getDoors()) {
                    if (door.getId().equals(sensorEvent.getObjectId())) {
                        changeState(room, door, sensorEvent);
                    }
                }

            }
        }
    }

    private void changeState(Room room, Door door, SensorEvent sensorEvent) {
        if (sensorEvent.getType() == DOOR_OPEN){
            door.setOpen(true);
            System.out.println("Door " + door.getId() + " in room " + room.getName() + " was opened.");
        }
        if (sensorEvent.getType() == DOOR_CLOSED){
            door.setOpen(false);
            System.out.println("Door " + door.getId() + " in room " + room.getName() + " was closed.");
            if (room.getName().equals("hall")) {
                new HallDoorScenario(smartHome).processScenario();
            }
        }
    }
}
