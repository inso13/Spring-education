package springTest.loggers;

import org.apache.commons.io.FileUtils;
import springTest.Event;

import java.io.File;
import java.io.IOException;


/**
 * Created by win-7.1 on 28.12.2016.
 */
public class FileEventLogger implements EventLogger {
    private String fileName;
    private File file;


    public FileEventLogger(String fileName) {
        this.fileName = fileName;
    }

    public void logEvent(Event event) {
        try {
            FileUtils.writeStringToFile(file, event.toString(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void init() throws IOException
    {
        this.file=new File(fileName);
        if (!file.canWrite()) throw new IOException();
    }

}
