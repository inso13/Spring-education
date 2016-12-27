package main.loggers;

/**
 * Created by win-7.1 on 27.12.2016.
 */
public class ConsoleEventLogger implements EventLogger {

    public void logEvent(String message) {
        System.out.println(message);
    }
}
