package springTest.loggers;

import springTest.Event;

import java.util.Collection;

/**
 * Created by Inso on 06.01.2017.
 */
public class CombinedEventLogger implements EventLogger {
    private Collection<EventLogger> loggers;

    public CombinedEventLogger(Collection<EventLogger> loggers) {
        this.loggers = loggers;
    }

    public void logEvent(Event event) {
        for (EventLogger eg:loggers)
            eg.logEvent(event);
    }
}
