package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.alarm.HomeAlarm;
import ru.sbt.mipt.oop.eventProcessors.Action;
import ru.sbt.mipt.oop.eventProcessors.Actionable;

import java.util.ArrayList;
import java.util.Collection;

public class SmartHome implements Actionable {
    private Collection<Room> rooms;
    private HomeAlarm alarm;

    public SmartHome() {
        rooms = new ArrayList<>();
    }

    public SmartHome(Collection<Room> rooms) {
        this.rooms = rooms;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void addAlarm(){
        this.alarm = new HomeAlarm();
    }

    public HomeAlarm getAlarm(){
        return this.alarm;
    }

    @Override
    public void execute(Action action) {
        action.execute(this);
        alarm.execute(action);
        for (Room room : rooms) {
            room.execute(action);
        }
    }
}
