package ru.sbt.mipt.oop.remoteControl.commands;

import ru.sbt.mipt.oop.alarm.HomeAlarm;

public class ActivateAlert implements CommandInterface {
    private HomeAlarm alarm;

    public ActivateAlert(HomeAlarm alarm){
        this.alarm = alarm;
    }

    @Override
    public void execute() {
        alarm.setToAlert();
    }
}
