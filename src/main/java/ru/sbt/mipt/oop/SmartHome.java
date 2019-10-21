package ru.sbt.mipt.oop;

import java.util.ArrayList;
import java.util.Collection;

public class SmartHome {
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

    public Collection<Room> getRooms() {
        return rooms;
    }

    public void setAllLights(EventType eventType){
        for (Room room: this.rooms){
            for (RoomObject roomObject: room.getRoomObject()){
                if (roomObject.getName().equals("light")){
                    roomObject.execute(eventType);
                }
            }
        }

    }
}
