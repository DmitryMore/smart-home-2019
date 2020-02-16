package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.sensor.SensorAlarmEvent;
import ru.sbt.mipt.oop.sensor.SensorDoorLightEvent;
import ru.sbt.mipt.oop.sensor.SensorEvent;
import ru.sbt.mipt.oop.sensor.SensorEventType;

public class EventGenerator {
    public static SensorEvent generateSensorEvent(){
        // pretend like we're getting the events from physical world, but here we're going to just generate some random events
        if (Math.random() < 0.05) return null; // null means end of event stream
        SensorEventType sensorEventType = SensorEventType.values()[(int) (6 * Math.random())];
        String objectId = "" + ((int) (10 * Math.random()));

        if (sensorEventType == SensorEventType.ALARM_ACTIVATE || sensorEventType == SensorEventType.ALARM_DEACTIVATE){
            if (Integer.parseInt(objectId) < 5) {
                return new SensorAlarmEvent(sensorEventType, objectId, "!QAZ@WSX#EDC");
            }else {
                return new SensorAlarmEvent(sensorEventType, objectId, "CDE#XSW@ZAQ!");
            }
        }else {
            return new SensorDoorLightEvent(sensorEventType, objectId);
        }
    }
}
