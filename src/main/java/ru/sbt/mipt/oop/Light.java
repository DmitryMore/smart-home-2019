package ru.sbt.mipt.oop;

public class Light implements RoomObject {
    private final String name = "light";
    private boolean isOn;
    private final String id;

    public Light(String id, boolean isOn) {
        this.id = id;
        this.isOn = isOn;
    }

    public boolean isOn() {
        return isOn;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    public boolean execute(EventType eventType){
        switch (eventType){
            case LIGHT_ON:
                this.setOn(true);
                return true;
            case LIGHT_OFF:
                this.setOn(false);
                return true;
            default:
                return false;
        }
    }
}
