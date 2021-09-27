package karlett.tasklist;

import karlett.storage.TaskListDecoder;
import karlett.storage.TaskListEncoder;
import karlett.task.Task;
import karlett.ui.TextUi;

import java.io.IOException;
import java.util.ArrayList;

public class TaskList {

    private int numberOfTasks;
    private ArrayList<Task> tasks;
    private TaskListEncoder taskListEncoder;

    public TaskList(ArrayList<Task> tasksArrayList, String filePath) {
        tasks = tasksArrayList;
        numberOfTasks = tasksArrayList.size();
        taskListEncoder = new TaskListEncoder(filePath);
    }

    public TaskList(String filePath) {
        tasks = new ArrayList<Task>();
        numberOfTasks = 0;
        taskListEncoder = new TaskListEncoder(filePath);
    }

    public int getNumberOfTasks() {
        return numberOfTasks;
    }

    public void add(Task task) throws IOException {
        tasks.add(task);
    }

    public void increaseNumberOfTasks() throws IOException {
        numberOfTasks++;
    }

    public void increaseNumberOfTasks(boolean isDone) throws IOException {
        numberOfTasks++;
    }

    public void decreaseNumberOfTasks() {
        numberOfTasks--;
    }

    public void remove(int index) throws IOException {
        for (int i = index; i < tasks.size(); i++) {
            tasks.set(i - 1, tasks.get(i));
        }
    }

    public void printList() {
        TextUi.drawDivider();
        if (numberOfTasks == 0) {
            System.out.println("You have done everything! Time to relax with Karlett meow ʕ♡ﻌ♡ʔ");
        } else {
            for (int i = 0; i < numberOfTasks; i++) {
                System.out.println("ฅ" + (i + 1) + " " + tasks.get(i));
            }
        }
        TextUi.drawDivider();
    }

    public Task get(int i) {
        return tasks.get(i);
    }
}
