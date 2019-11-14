package ru.sbt.mipt.oop.homeReader;

import com.google.gson.Gson;
import ru.sbt.mipt.oop.SmartHome;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class HomeReaderGson implements HomeReader {
    private Gson gson;
    private String json;

    public HomeReaderGson() {
        this.gson = new Gson();
    }

    public HomeReaderGson(String path) throws IOException {
        this.gson = new Gson();
        this.json = new String(Files.readAllBytes(Paths.get(path)));
    }

    public void setFilePath(String path) throws IOException {
        this.json = new String(Files.readAllBytes(Paths.get(path)));
    }

    @Override
    public SmartHome fileToSmartHome() {
        return gson.fromJson(json, SmartHome.class);
    }
}
