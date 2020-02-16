package ru.sbt.mipt.oop.eventProcessors;

import ru.sbt.mipt.oop.Door;
import ru.sbt.mipt.oop.Light;
import ru.sbt.mipt.oop.Room;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.sensor.SensorEvent;

import static ru.sbt.mipt.oop.sensor.SensorEventType.*;

public class HallDoorEventProcessor implements EventProcessor {

    public HallDoorEventProcessor(){}

    @Override
    public void processEvent(SmartHome smartHome, SensorEvent sensorEvent) {
        smartHome.execute(object -> {
            if (object instanceof Room) {
                Room room = (Room) object;
                if (room.getName().equals("hall")) {
                    room.execute(doorObject -> {
                        if (!(doorObject instanceof Door)) return;
                        Door door = (Door) doorObject;
                        if (sensorEvent.getObjectId().equals(door.getId()) && door.isOpen()) {
                            this.changeState(smartHome, sensorEvent);
                        }
                    });
                }
            }
        });
    }

    private void changeState(SmartHome smartHome, SensorEvent sensorEvent){
        if (sensorEvent.getType() != DOOR_CLOSED) return;
        smartHome.execute(object -> {
            if (!(object instanceof Light)) return;
            Light light = (Light) object;
            if (light.isOn()) {
                light.setOn(false);
                System.out.println("Light: " + light.getId() + " was turned off");
            }
        });
    }


}
