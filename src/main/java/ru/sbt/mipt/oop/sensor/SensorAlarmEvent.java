package ru.sbt.mipt.oop.sensor;

public class SensorAlarmEvent implements SensorEvent {
    private final SensorEventType type;
    private final String objectId;
    private String code;

    public SensorAlarmEvent(SensorEventType type, String objectId, String code) {
        this.type = type;
        this.objectId = objectId;
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    @Override
    public SensorEventType getType() {
        return type;
    }

    @Override
    public String getObjectId() {
        return objectId;
    }

    @Override
    public String toString() {
        return "SensorEvent{" +
                "type=" + type +
                ", objectId='" + objectId + '\'' +
                '}';
    }
}
