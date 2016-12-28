package springTest;


import java.text.DateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by Котик on 27.12.2016.
 */
public class Event {
    private int id;
    private String message;
    private Date date;
    private DateFormat df;
    private Random random = new Random();
    {this.id = random.nextInt();}

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Event(Date date, DateFormat df) {
        this.date=date;
        this.df=df;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", date=" + date +
                ", df=" +
                 df.format(date)+'}'+"\n";
    }
}
