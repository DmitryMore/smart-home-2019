package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.homeReader.HomeReaderInterface;
import ru.sbt.mipt.oop.homeReader.HomeReaderGson;
import ru.sbt.mipt.oop.sensor.*;

import java.io.IOException;

public class Application {

    public static void main(String... args) throws IOException {
        // считываем состояние дома из файла
        HomeReaderInterface homeReader = new HomeReaderGson("smart-home-1.js");
        SmartHome smartHome = homeReader.fileToSmartHome();
        SensorEventHandler sensorEventHandler = new SensorEventHandler(smartHome);

        // начинаем цикл обработки событий
        sensorEventHandler.run();
    }
}
