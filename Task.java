
import java.time.LocalDateTime;


public class Task {
    private String minute;
    private String hour;
    private String day;
    private String month;
    private String weekday;
    private String path;
    private boolean run = false;

    public Task(String minute, String hour, String day, String month, String weekday, String path) {
        this.minute = minute;
        this.hour = hour;
        this.day = day;
        this.month = month;
        this.weekday = weekday;
        this.path = path;
    }

    public LocalDateTime getTime() {
        String time = LocalDateTime.now().getYear() + "-" + month + "-" + day + "T" + hour + ":" + minute;
        return LocalDateTime.parse(replaceStars(time));
    }

    private String replaceStars(String dateTime)  {
        LocalDateTime ldt = LocalDateTime.now();
        String[] subtime = dateTime.split("T");
        String[] date = subtime[0].split("-");
        String[] time = subtime[1].split(":");

        if (date[1].equals("*")) date[1] = String.valueOf(ldt.getMonthValue());
        if (date[1].length() <= 1) date[1] = "0"+date[1];

        if (date[2].equals("*")) date[2] = String.valueOf(ldt.getDayOfMonth());
        if (date[2].length() <= 1) date[2] = "0"+date[2];

        if (time[0].equals("*")) time[0] = String.valueOf(ldt.getHour());
        if (time[0].length() <= 1) time[0] = "0"+time[0];

        if (time[1].equals("*")) time[1] = String.valueOf(ldt.getMinute());
        if (time[1].length() <= 1) time[1] = "0"+time[1];


        return date[0]+"-"+date[1]+"-"+date[2]+"T"+time[0]+":"+time[1];
    }

    public String getPath() {
        return path;
    }

    public boolean isRun() {
        return run;
    }

    public void setRun(boolean run) {
        this.run = run;
    }
}
