package ru.sbt.mipt.oop.adapters;

import com.coolcompany.smarthome.events.CCSensorEvent;
import ru.sbt.mipt.oop.sensor.SensorDoorLightEvent;
import ru.sbt.mipt.oop.sensor.SensorEvent;
import ru.sbt.mipt.oop.sensor.SensorEventType;

public class LightEventAdapter implements CCSensorEventAdapter {
    private CCSensorEventAdapter ccSensorEventAdapter;

    public LightEventAdapter(CCSensorEventAdapter ccSensorEventAdapter) {
        this.ccSensorEventAdapter = ccSensorEventAdapter;
    }

    @Override
    public SensorEvent convert(CCSensorEvent ccSensorEvent) {
        if (ccSensorEvent.getEventType().equals("LightIsOn")) {
            return new SensorDoorLightEvent(SensorEventType.LIGHT_ON, ccSensorEvent.getObjectId());
        } else if (ccSensorEvent.getEventType().equals("LightIsOff")) {
            return new SensorDoorLightEvent(SensorEventType.LIGHT_OFF, ccSensorEvent.getObjectId());
        } else if (ccSensorEventAdapter == null) {
            return null;
        }
        return ccSensorEventAdapter.convert(ccSensorEvent);
    }
}
