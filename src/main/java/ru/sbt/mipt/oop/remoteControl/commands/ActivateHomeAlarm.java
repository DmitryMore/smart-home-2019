package ru.sbt.mipt.oop.remoteControl.commands;

import ru.sbt.mipt.oop.alarm.HomeAlarm;

public class ActivateHomeAlarm implements CommandInterface {
    private HomeAlarm alarm;
    private String code;

    public ActivateHomeAlarm(HomeAlarm alarm, String code){
        this.alarm = alarm;
        this.code = code;
    }

    @Override
    public void execute() {
        alarm.activate(code);
    }
}
