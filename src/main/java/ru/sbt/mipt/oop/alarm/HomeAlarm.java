package ru.sbt.mipt.oop.alarm;

import ru.sbt.mipt.oop.eventProcessors.Action;
import ru.sbt.mipt.oop.eventProcessors.Actionable;

public class HomeAlarm implements Actionable {
    private String code;
    private AlarmStatesInterface alarmState;

    public HomeAlarm(){
        this.code = "";
        this.alarmState = new DeactivatedState(this);
    }

    void setCode(String code){
        this.code = code;
    }

    void setAlarmState(AlarmStatesInterface alarmState){
        this.alarmState = alarmState;
    }

    public AlarmStatesInterface getAlarmState(){
        return alarmState;
    }

    boolean checkCode(String code){
        return this.code.equals(code);
    }

    public void activate(String code){
        alarmState.activate(code);
    }

    public void deactivate(String code) {
        this.alarmState.deactivate(code);
    }

    public void setToAlert(){
        alarmState.setToAlarm();
    }



    @Override
    public void execute(Action action) {
        action.execute(this);
    }
}
