package ru.sbt.mipt.oop.remoteControl.commands;

import ru.sbt.mipt.oop.Light;
import ru.sbt.mipt.oop.SmartHome;

public class SetOnAllLight implements CommandInterface {
    private SmartHome smartHome;

    public SetOnAllLight(SmartHome smartHome){
        this.smartHome = smartHome;
    }
    @Override
    public void execute() {
        smartHome.execute(object -> {
            if (object instanceof Light) {
                Light light = (Light) object;
                light.setOn(true);
            }
        });
    }
}
