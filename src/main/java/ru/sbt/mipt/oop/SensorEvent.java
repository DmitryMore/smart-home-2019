package ru.sbt.mipt.oop;

public class SensorEvent {
    private final EventType type;
    private final String objectId;
    private final String objectName;

    public SensorEvent(EventType type, String objectId, String objectName) {
        this.type = type;
        this.objectId = objectId;
        this.objectName = objectName;
    }

    public EventType getType() {
        return type;
    }

    public String getObjectId() {
        return objectId;
    }

    public String getObjectName() {
        return objectName;
    }

    @Override
    public String toString() {
        return "SensorEvent{" +
                "type=" + type +
                ", objectId='" + objectId + '\'' +
                '}';
    }
}
