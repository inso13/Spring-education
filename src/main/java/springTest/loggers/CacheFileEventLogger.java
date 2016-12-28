package springTest.loggers;

import springTest.Event;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by win-7.1 on 28.12.2016.
 */
public class CacheFileEventLogger extends FileEventLogger {
    private int cacheSize;
    private List<Event> cache = new ArrayList<Event>();


    public CacheFileEventLogger(String fileName, int cacheSize) {
        super(fileName);
        this.cacheSize = cacheSize;
    }

    @Override
    public void logEvent(Event event) {
        cache.add(event);
        if (cache.size()==cacheSize)
        {
            writeEventsFromCache();
            cache.clear();
        }
    }

    public void writeEventsFromCache()
    {
        for (Event e:cache)
            super.logEvent(e);
    }

    @Override
    public void init() throws IOException {
        super.init();
    }

    public void destroy()
    {
        if (!cache.isEmpty())
            writeEventsFromCache();
    }
}
