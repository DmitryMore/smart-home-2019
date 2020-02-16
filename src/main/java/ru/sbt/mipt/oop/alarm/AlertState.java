package ru.sbt.mipt.oop.alarm;

public class AlertState implements AlarmStatesInterface {
    private HomeAlarm homeAlarm;

    AlertState(HomeAlarm homeAlarm) {
        this.homeAlarm = homeAlarm;
    }

    @Override
    public void activate(String code) {
    }

    @Override
    public void deactivate(String code) {
        if (homeAlarm.checkCode(code)){
            homeAlarm.setAlarmState(new DeactivatedState(homeAlarm));
            homeAlarm.setCode("");
            System.out.println("Home alarm has been deactivated");
        }else{
            System.out.println("Alarm! Alarm! Alarm!");
        }
    }

    @Override
    public void setToAlarm() {
    }
}
