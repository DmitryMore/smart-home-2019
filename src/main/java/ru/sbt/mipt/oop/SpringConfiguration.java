package ru.sbt.mipt.oop;

import com.coolcompany.smarthome.events.SensorEventsManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ru.sbt.mipt.oop.adapters.CCSensorEventAdapter;
import ru.sbt.mipt.oop.adapters.DoorEventAdapter;
import ru.sbt.mipt.oop.adapters.EventHandlerAdapter;
import ru.sbt.mipt.oop.adapters.LightEventAdapter;
import ru.sbt.mipt.oop.alarm.HomeAlarm;
import ru.sbt.mipt.oop.eventProcessors.*;
import ru.sbt.mipt.oop.homeReader.HomeReaderGson;
import ru.sbt.mipt.oop.homeReader.HomeReaderInterface;

import java.io.IOException;
import java.util.List;

@Configuration
@Import(RemoteControlConfiguration.class)
public class SpringConfiguration {

    @Bean
    SensorEventsManager sensorEventsManager(EventProcessor eventProcessor, CCSensorEventAdapter ccSensorEventAdapter) throws IOException {
        SensorEventsManager sensorEventsManager = new SensorEventsManager();
        EventHandlerAdapter eventHandlerAdapter = new EventHandlerAdapter(eventProcessor, ccSensorEventAdapter, smartHome());
        sensorEventsManager.registerEventHandler(eventHandlerAdapter);
        return sensorEventsManager;
    }

    @Bean
    public EventProcessor eventProcessor(List<EventProcessor> processors) {
        return new EventProcessorDecorator(processors);
    }

    @Bean
    EventProcessor lightEventProcessor() {
        return new LightEventProcessor();
    }

    @Bean
    EventProcessor hallDoorEventProcessor() {
        return new HallDoorEventProcessor();
    }

    @Bean
    EventProcessor doorEventProcessor() {
        return new DoorEventProcessor();
    }

    @Bean
    EventProcessor alarmEventProcessor() {
        return new AlarmEventProcessor();
    }

    @Bean
    public SmartHome smartHome() throws IOException {
        HomeReaderInterface homeReader = new HomeReaderGson("smart-home-1.js");
        SmartHome smartHome = homeReader.fileToSmartHome();
        smartHome.addAlarm();
        return smartHome;
    }

    @Bean
    HomeAlarm alarm() throws IOException {
        SmartHome smartHome = smartHome();
        return smartHome.getAlarm();
    }

    @Bean
    public CCSensorEventAdapter ccSensorEventAdapter(DoorEventAdapter doorEventAdapter) {
        return new DoorEventAdapter(doorEventAdapter);
    }

    @Bean
    public DoorEventAdapter doorEventAdapter(LightEventAdapter lightEventAdapter) {
        return new DoorEventAdapter(lightEventAdapter);
    }

    @Bean
    public LightEventAdapter lightEventAdapter() {
        return new LightEventAdapter(null);
    }
}
