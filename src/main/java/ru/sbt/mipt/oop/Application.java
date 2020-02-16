package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.eventProcessors.DoorEventProcessor;
import ru.sbt.mipt.oop.eventProcessors.EventProcessor;
import ru.sbt.mipt.oop.eventProcessors.HallDoorEventProcessor;
import ru.sbt.mipt.oop.eventProcessors.LightEventProcessor;
import ru.sbt.mipt.oop.homeReader.HomeReaderInterface;
import ru.sbt.mipt.oop.homeReader.HomeReaderGson;
import ru.sbt.mipt.oop.sensor.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String... args) throws IOException {
        // считываем состояние дома из файла
        HomeReaderInterface homeReader = new HomeReaderGson("smart-home-1.js");
        SmartHome smartHome = homeReader.fileToSmartHome();

        // создаём обработчик событий
        List<EventProcessor> eventProcessors = new ArrayList<>();
        eventProcessors.add(new DoorEventProcessor());
        eventProcessors.add(new HallDoorEventProcessor());
        eventProcessors.add(new LightEventProcessor());
        SensorEventHandler sensorEventHandler = new SensorEventHandler(smartHome, eventProcessors);

        // начинаем цикл обработки событий
        sensorEventHandler.run();
    }
}
