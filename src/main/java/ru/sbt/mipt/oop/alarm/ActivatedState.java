package ru.sbt.mipt.oop.alarm;

public class ActivatedState implements AlarmStatesInterface {
    private HomeAlarm homeAlarm;

    ActivatedState(HomeAlarm homeAlarm) {
        this.homeAlarm = homeAlarm;
    }

    @Override
    public void activate(String code) {
        System.out.println("Alarm is already activated");
    }

    @Override
    public void deactivate(String code) {
        if (homeAlarm.checkCode(code)){
            homeAlarm.setAlarmState(new DeactivatedState(homeAlarm));
            homeAlarm.setCode("");
            System.out.println("Home alarm has been deactivated");
        }else{
            this.setToAlarm();
        }
    }

    @Override
    public void setToAlarm() {
        homeAlarm.setAlarmState(new AlertState(homeAlarm));
        homeAlarm.setToAlert();
        System.out.println("Alarm! Alarm! Alarm!");
    }
}
