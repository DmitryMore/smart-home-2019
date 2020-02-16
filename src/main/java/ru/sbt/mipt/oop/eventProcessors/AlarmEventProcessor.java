package ru.sbt.mipt.oop.eventProcessors;

import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.alarm.HomeAlarm;
import ru.sbt.mipt.oop.sensor.SensorAlarmEvent;
import ru.sbt.mipt.oop.sensor.SensorEvent;

import static ru.sbt.mipt.oop.sensor.SensorEventType.*;

public class AlarmEventProcessor implements EventProcessor {

    public AlarmEventProcessor() {}

    @Override
    public void processEvent(SmartHome smartHome, SensorEvent sensorEvent) {
        smartHome.execute(object -> {
            if (!(object instanceof HomeAlarm)) return;
            HomeAlarm alarm = (HomeAlarm) object;
            changeState(alarm, sensorEvent);
        });
    }

    private void changeState(HomeAlarm alarm, SensorEvent sensorEvent){
        if (sensorEvent.getType() == ALARM_ACTIVATE){
            alarm.activate(((SensorAlarmEvent) sensorEvent).getCode());
        }
        if (sensorEvent.getType() == ALARM_DEACTIVATE){
            alarm.deactivate(((SensorAlarmEvent) sensorEvent).getCode());
        }
    }
}
