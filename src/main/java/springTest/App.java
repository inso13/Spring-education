package springTest;




import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import springTest.loggers.EventLogger;

/**
 * Created by win-7.1 on 27.12.2016.
 */
public class App {
    private Client client;
    private EventLogger eventLogger;


    public void logEvent(String message, Event event)
    {
        String result = message.replaceAll(String.valueOf(client.getId()), client.getName());

        event.setMessage(result);
        eventLogger.logEvent(event);
    }

    public static void main(String[] args)
    {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        App app = ctx.getBean(App.class);
        Event event = ctx.getBean(Event.class);
       app.logEvent("some event for user 1", event);
        Event event2 = ctx.getBean(Event.class);
       app.logEvent("some event for user 2", event2);
        Event event3 = ctx.getBean(Event.class);
        app.logEvent("some event for user 1", event3);
        ctx.close();
    }

    public App(Client client, EventLogger eventLogger) {
        this.client = client;
        this.eventLogger = eventLogger;
    }

}
