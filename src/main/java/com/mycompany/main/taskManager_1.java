/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;
import javax.swing.*;
import java.util.ArrayList;
/**
 *
 * @author Muthivhi_Tshedza
 */
class taskManager {
    private final ArrayList<Task> tasks = new ArrayList<>();

    public void addTask(Task task) {
        tasks.add(task);
    }

    public String displayDoneTasks() {
        StringBuilder result = new StringBuilder("Tasks with status 'Done':\n");
        for (Task task : tasks) {
            if (task.getTaskStatus().equalsIgnoreCase("done")) {
                result.append(task.getDeveloperDetails())
                      .append(", ").append(task.getTaskName())
                      .append(", Duration: ").append(task.returnTotalHours()).append("\n");
            }
        }
        return result.toString();
    }

    public String findLongestDuration() {
        Task longestTask = null;
        for (Task task : tasks) {
            if (longestTask == null || task.returnTotalHours() > longestTask.returnTotalHours()) {
                longestTask = task;
            }
        }
        return longestTask != null ? longestTask.getDeveloperDetails() + ", " + longestTask.returnTotalHours() : "No tasks found.";
    }

    public String searchTaskByName(String taskName) {
        for (Task task : tasks) {
            if (task.getTaskName().equalsIgnoreCase(taskName)) {
                return task.getTaskName() + ", " + task.getDeveloperDetails() + ", Status: " + task.getTaskStatus();
            }
        }
        return "Task not found.";
    }

    public String searchTasksByDeveloper(String developer) {
        StringBuilder result = new StringBuilder("Tasks for " + developer + ":\n");
        for (Task task : tasks) {
            if (task.getDeveloperDetails().equalsIgnoreCase(developer)) {
                result.append(task.getTaskName()).append(", Status: ").append(task.getTaskStatus()).append("\n");
            }
        }
        return result.toString();
    }

    public String deleteTaskByName(String taskName) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getTaskName().equalsIgnoreCase(taskName)) {
                tasks.remove(i);
                return "Entry '" + taskName + "' successfully deleted.";
            }
        }
        return "Task not found.";
    }

    public String displayAllTasks() {
        StringBuilder result = new StringBuilder("Full Task Report:\n");
        for (Task task : tasks) {
            result.append(task.printTaskDetails()).append("\n");
        }
        return result.toString();
    }
}
    

