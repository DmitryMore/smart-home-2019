package ru.sbt.mipt.oop.alarm;

public class DeactivatedState implements AlarmStatesInterface {
    private HomeAlarm homeAlarm;
    public DeactivatedState(HomeAlarm homeAlarm) {
        this.homeAlarm = homeAlarm;
    }

    @Override
    public void activate(String code) {
        homeAlarm.setCode(code);
        homeAlarm.setAlarmState(new ActivatedState(homeAlarm));
        System.out.println("Home alarm has been activated");
    }

    @Override
    public void deactivate(String code) {
        System.out.println("Alarm is already deactivated");
    }

    @Override
    public void setToAlarm() {
    }
}
