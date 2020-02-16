package ru.sbt.mipt.oop.remoteControl.commands;

import ru.sbt.mipt.oop.Light;
import ru.sbt.mipt.oop.Room;
import ru.sbt.mipt.oop.SmartHome;

public class SetOnHallLight implements CommandInterface {
    private SmartHome smartHome;

    public SetOnHallLight(SmartHome smartHome){
        this.smartHome = smartHome;
    }
    @Override
    public void execute() {
        smartHome.execute(object_room -> {
            if (object_room instanceof Room) {
                Room room = (Room) object_room;

                if (room.getName().equals("Hall")) {
                    room.execute(object_light -> {
                        if (object_light instanceof Light) {
                            Light light = (Light) object_light;
                            light.setOn(true);
                        }
                    });
                }
            }
        });
    }
}
