package main;

import main.loggers.ConsoleEventLogger;

/**
 * Created by win-7.1 on 27.12.2016.
 */
public class App {
    private Client client;
    private ConsoleEventLogger consoleEventLogger;

    public void logEvent(String message)
    {
        String result = message.replaceAll(String.valueOf(client.getId()), client.getName());
        consoleEventLogger.logEvent(result);
    }

    public static void main(String[] args)
    {
        App app = new App();
        app.client=new Client(1, "John Smith");
        app.consoleEventLogger=new ConsoleEventLogger();
        app.logEvent("some event for user 1");
    }
}
