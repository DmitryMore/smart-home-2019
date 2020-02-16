package ru.sbt.mipt.oop.scenario;

import ru.sbt.mipt.oop.*;
import ru.sbt.mipt.oop.sensor.SensorCommand;
import ru.sbt.mipt.oop.sensor.SensorCommandType;


public class HallDoorScenario {
    private final SmartHome smartHome;

    public HallDoorScenario(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    public void processScenario() {
        for (Room homeRoom : smartHome.getRooms()) {
            for (Light light : homeRoom.getLights()) {
                light.setOn(false);
                SensorCommand command = new SensorCommand(SensorCommandType.LIGHT_OFF, light.getId());
                CommandSender.sendCommand(command);
            }
        }
    }
}

