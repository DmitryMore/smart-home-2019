package ru.sbt.mipt.oop.homeReader;

import ru.sbt.mipt.oop.SmartHome;

import java.io.IOException;

public interface HomeReader {
    SmartHome fileToSmartHome();
}
