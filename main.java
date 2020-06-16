import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class main {
    public static void main(String[] args) throws IOException, InterruptedException {
        while (true) {
            List<Task> taskList = shouldRun(readFile(args[0]));
            for (Task task : taskList) {
                if (task.isRun()) Desktop.getDesktop().open(new File(task.getPath()));
            }
            sleep(1000*60);
        }

    }

    private static List<Task> readFile(String fname) throws FileNotFoundException {
        List<Task> taskList = new ArrayList<>();
        try (Scanner sc = new Scanner(new File(fname))) {
            while (sc.hasNextLine()) {
                String[] line = sc.nextLine().split(" ");
                Task uus = new Task(line[0], line[1], line[2], line[3], line[4], line[5]);
                taskList.add(uus);
            }
        }
        return taskList;
    }

    public static List<Task> shouldRun(List<Task> tasks) {
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
