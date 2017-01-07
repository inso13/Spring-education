package springTest;




import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import springTest.loggers.EventLogger;

import java.util.Map;

/**
 * Created by win-7.1 on 27.12.2016.
 */
public class App {
    private Client client;
    private EventLogger defaultLogger;
   private Map<EventType, EventLogger> loggers;


    public void logEvent(String message, Event event, EventType type)
    {
        EventLogger logger = loggers.get(type);
        if (logger==null) logger=defaultLogger;
        String result = client.getGreeting()+" "+message.replaceAll(String.valueOf(client.getId()), client.getName());
        event.setMessage(result);
        logger.logEvent(event);
    }

    public static void main(String[] args)
    {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        App app = ctx.getBean(App.class);
        Event event = ctx.getBean(Event.class);
       app.logEvent("some event for user 1", event, EventType.ERROR);
        Event event2 = ctx.getBean(Event.class);
       app.logEvent("some event for user 2", event2, EventType.ERROR);
        Event event3 = ctx.getBean(Event.class);
        app.logEvent("some event for user 1", event3, EventType.INFO);
        ctx.close();
    }

    public App(Client client, EventLogger eventLogger, Map<EventType, EventLogger> loggers) {
        this.client = client;
        this.defaultLogger = eventLogger;
        this.loggers=loggers;
    }

}
