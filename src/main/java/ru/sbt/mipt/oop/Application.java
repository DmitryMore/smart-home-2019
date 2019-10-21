package ru.sbt.mipt.oop;

import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static ru.sbt.mipt.oop.EventType.*;

public class Application {

    public static void main(String... args) throws IOException {
        // считываем состояние дома из файла
        Gson gson = new Gson();
        String json = new String(Files.readAllBytes(Paths.get("smart-home-1.js")));
        SmartHome smartHome = gson.fromJson(json, SmartHome.class);

        for (Room room: smartHome.getRooms()){
            room.toRoomObject();
        }

        // начинаем цикл обработки событий
        SensorEvent event = getNextSensorEvent();
        while (event != null) {
            System.out.println("Got event: " + event);

            for (Room room : smartHome.getRooms()) {
                for (RoomObject roomObject : room.getRoomObject()) {
                    if (roomObject.getId().equals(event.getObjectId()) && roomObject.getName().equals(event.getObjectName())) {
                        roomObject.execute(event.getType());
                        System.out.println(roomObject.getName() + " "
                                + roomObject.getId() + " is "
                                + event.getType().toString().split("_")[1].toLowerCase()
                                + " in room " + room.getName());
                        if (room.getName().equals("hall") && roomObject.getName().equals("door")) {
                            smartHome.setAllLights(EventType.LIGHT_OFF);
                        }
                    }

                }
            }
            event = getNextSensorEvent();
        }
    }

    private static void sendCommand(SensorCommand command) {
        System.out.println("Pretend we're sending command " + command);
    }

    private static SensorEvent getNextSensorEvent() {
        // pretend like we're getting the events from physical world, but here we're going to just generate some random events
        if (Math.random() < 0.05) return null; // null means end of event stream
        EventType sensorEventType = EventType.values()[(int) (4 * Math.random())];
        String objectName = sensorEventType.toString().split("_")[0].toLowerCase();
        String objectId = "" + ((int) (10 * Math.random()));
        return new SensorEvent(sensorEventType, objectId, objectName);
    }
}
