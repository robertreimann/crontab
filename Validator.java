import java.time.LocalDateTime;
import java.util.List;

public class Validator {
    public List<Task> shouldRun(List<Task> tasks) {
        LocalDateTime ldt = LocalDateTime.now();
        for (Task task : tasks) {
            LocalDateTime tdt = task.getTime();

            if (tdt.getMinute() == ldt.getMinute() &&
                    tdt.getHour() == ldt.getHour() &&
                    tdt.getDayOfMonth() == ldt.getDayOfMonth() &&
                    tdt.getMonthValue() == ldt.getMonthValue() &&
                    tdt.getDayOfWeek() == ldt.getDayOfWeek()) {
                task.setRun(true);
            }
        }
        return tasks;
    }


}
