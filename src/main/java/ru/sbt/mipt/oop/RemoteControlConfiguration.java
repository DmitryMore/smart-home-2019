package ru.sbt.mipt.oop;

import org.springframework.context.annotation.Bean;
import rc.RemoteControl;
import rc.RemoteControlRegistry;
import ru.sbt.mipt.oop.alarm.HomeAlarm;
import ru.sbt.mipt.oop.remoteControl.RemoteControlImpl;
import ru.sbt.mipt.oop.remoteControl.commands.*;

public class RemoteControlConfiguration {
    @Bean
    RemoteControl remoteControlRealisation(CloseHallDoor closeHallDoor,
                                           SetOnHallLight turnOnHallLight,
                                           SetOnAllLight turnOnAllLight,
                                           SetOffAllLight turnOffAllLight,
                                           ActivateHomeAlarm activateAlarm,
                                           ActivateAlert activateAlert) {
        RemoteControlImpl remoteControlImpl = new RemoteControlImpl();
        remoteControlImpl.addRemoteControlCommands("A", closeHallDoor);
        remoteControlImpl.addRemoteControlCommands("B", turnOnHallLight);
        remoteControlImpl.addRemoteControlCommands("C", turnOnAllLight);
        remoteControlImpl.addRemoteControlCommands("D", turnOffAllLight);
        remoteControlImpl.addRemoteControlCommands("1", activateAlarm);
        remoteControlImpl.addRemoteControlCommands("2", activateAlert);

        remoteControlRegistry().registerRemoteControl(remoteControlImpl, "QWE123");

        return remoteControlImpl;
    }

    @Bean
    RemoteControlRegistry remoteControlRegistry() {
        return new RemoteControlRegistry();
    }

    @Bean
    CloseHallDoor closeHallDoor(SmartHome smartHome) {
        return new CloseHallDoor(smartHome);
    }

    @Bean
    SetOnHallLight turnOnHallLight(SmartHome smartHome) {
        return new SetOnHallLight(smartHome);
    }

    @Bean
    SetOnAllLight turnOnAllLight(SmartHome smartHome) {
        return new SetOnAllLight(smartHome);
    }

    @Bean
    SetOffAllLight turnOffAllLight(SmartHome smartHome) {
        return new SetOffAllLight(smartHome);
    }

    @Bean
    ActivateHomeAlarm activateAlarm(HomeAlarm alarm) {
        return new ActivateHomeAlarm(alarm, "!QAZ@WSX#EDC");
    }

    @Bean
    ActivateAlert activateAlert(HomeAlarm alarm) {
        return new ActivateAlert(alarm);
    }
}
