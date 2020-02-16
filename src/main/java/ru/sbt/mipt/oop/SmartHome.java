package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.eventProcessors.Action;
import ru.sbt.mipt.oop.eventProcessors.Actionable;

import java.util.ArrayList;
import java.util.Collection;

public class SmartHome implements Actionable {
    private Collection<Room> rooms;

    public SmartHome() {
        rooms = new ArrayList<>();
    }

    public SmartHome(Collection<Room> rooms) {
        this.rooms = rooms;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    @Override
    public void execute(Action action) {
        action.execute(this);
        for (Room room : rooms) {
            room.execute(action);
        }
    }
}
