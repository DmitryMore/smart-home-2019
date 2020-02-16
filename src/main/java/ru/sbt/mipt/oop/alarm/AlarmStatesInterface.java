package ru.sbt.mipt.oop.alarm;

public interface AlarmStatesInterface {
    void activate(String code);
    void deactivate(String code);
    void setToAlarm();
}
