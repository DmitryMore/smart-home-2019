package ru.sbt.mipt.oop.remoteControl.commands;

import ru.sbt.mipt.oop.Door;
import ru.sbt.mipt.oop.Room;
import ru.sbt.mipt.oop.SmartHome;

public class CloseHallDoor implements CommandInterface {
    private SmartHome smartHome;

    public CloseHallDoor(SmartHome smartHome){
        this.smartHome = smartHome;
    }

    @Override
    public void execute() {
        smartHome.execute(room_object -> {
            if(room_object instanceof Room) {
                Room room = (Room) room_object;
                if (room.getName().equals("Hall")) {
                    room.execute(door_object -> {
                        if(door_object instanceof Door) {
                            Door door = (Door) door_object;
                            door.setOpen(false);
                        }
                    });
                }
            }
        });
    }
}
