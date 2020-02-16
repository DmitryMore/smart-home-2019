package ru.sbt.mipt.oop.adapters;

import com.coolcompany.smarthome.events.CCSensorEvent;
import ru.sbt.mipt.oop.sensor.SensorDoorLightEvent;
import ru.sbt.mipt.oop.sensor.SensorEvent;
import ru.sbt.mipt.oop.sensor.SensorEventType;

public class DoorEventAdapter implements CCSensorEventAdapter {
    private CCSensorEventAdapter ccSensorEventAdapter;

    public DoorEventAdapter(CCSensorEventAdapter ccSensorEventAdapter) {
        this.ccSensorEventAdapter = ccSensorEventAdapter;
    }

    @Override
    public SensorEvent convert(CCSensorEvent ccSensorEvent) {
        if (ccSensorEvent.getEventType().equals("DoorIsOpen") || ccSensorEvent.getEventType().equals("DoorIsUnlocked")) {
            return new SensorDoorLightEvent(SensorEventType.DOOR_OPEN, ccSensorEvent.getObjectId());
        } else if (ccSensorEvent.getEventType().equals("DoorIsClosed") || ccSensorEvent.getEventType().equals("DoorIsLocked")) {
            return new SensorDoorLightEvent(SensorEventType.DOOR_CLOSED, ccSensorEvent.getObjectId());
        } else if (ccSensorEventAdapter == null) {
            return null;
        }
        return ccSensorEventAdapter.convert(ccSensorEvent);
    }
}
