package springTest.loggers;


import springTest.Event;

/**
 * Created by win-7.1 on 27.12.2016.
 */
public class ConsoleEventLogger implements EventLogger {

    public void logEvent(Event event) {
        System.out.println(event.toString());
    }
}
