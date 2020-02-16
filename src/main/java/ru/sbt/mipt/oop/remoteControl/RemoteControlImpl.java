package ru.sbt.mipt.oop.remoteControl;

import rc.RemoteControl;
import ru.sbt.mipt.oop.remoteControl.commands.CommandInterface;

import java.util.HashMap;

public class RemoteControlImpl implements RemoteControl {
    private HashMap<String, CommandInterface> remoteControlCommands;

    public RemoteControlImpl() {
        this.remoteControlCommands = new HashMap<>();
    }

    public void addRemoteControlCommands(String buttonType, CommandInterface command) {
        remoteControlCommands.put(buttonType, command);
    }

    @Override
    public void onButtonPressed(String buttonCode, String rcId) {
        if (remoteControlCommands.containsKey(buttonCode)) {
            remoteControlCommands.get(buttonCode).execute();
        }
    }
}
