package ru.sbt.mipt.oop;

public interface RoomObject {

    String getId();

    String getName();

    boolean execute(EventType eventType);

}
