package ru.sbt.mipt.oop;

public class Door implements RoomObject {
    private final String name = "door";
    private final String id;
    private boolean isOpen;

    public Door(boolean isOpen, String id) {
        this.isOpen = isOpen;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public boolean execute(EventType eventType){
        switch (eventType){
            case DOOR_OPEN:
                this.setOpen(true);
                return true;
            case DOOR_CLOSED:
                this.setOpen(false);
                return true;
            default:
                return false;
        }
    }
}
