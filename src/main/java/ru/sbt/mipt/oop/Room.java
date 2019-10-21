package ru.sbt.mipt.oop;

import java.util.ArrayList;
import java.util.Collection;

public class Room {
    private Collection<Light> lights;
    private Collection<Door> doors;
    private Collection<RoomObject> roomObjects;
    private String name;

    public Room(Collection<Light> lights, Collection<Door> doors, String name) {
        this.lights = lights;
        this.doors = doors;
        this.name = name;
    }

    public Collection<RoomObject> getRoomObject() {
        return roomObjects;
    }

    public void toRoomObject(){
        this.roomObjects = new ArrayList<>(lights);
        this.roomObjects.addAll(doors);
    }

    public String getName() {
        return name;
    }
}
