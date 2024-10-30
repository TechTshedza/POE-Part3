/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;
import javax.swing.JOptionPane;
/**
 *
 * @author Muthivhi_Tshedza
 */
class Task {
    private String taskName;
    private String taskDescription;
    private String developerDetails;
    private int duration;
    private String taskStatus;
    private static int taskNumberCounter = 0; // Tracks task number
    private String taskId;

    // Constructor for Task
    public Task(String taskName, String taskDescription, String developerDetails, int duration, String taskStatus) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.developerDetails = developerDetails;
        this.duration = duration;
        this.taskStatus = taskStatus;
        this.taskId = createTaskID();
        taskNumberCounter++;
    }

    // Method to check task description length
    public boolean checkTaskDescription() {
        return taskDescription.length() <= 50;
    }

    // Method to create a unique task ID
    public String createTaskID() {
        return taskName.substring(0, 2).toUpperCase() + ":" + (taskNumberCounter) + ":" + developerDetails.substring(developerDetails.length() - 3).toUpperCase();
    }

    // Method to print task details
    public String printTaskDetails() {
        return "Task Status: " + taskStatus +
               "\nDeveloper Details: " + developerDetails +
               "\nTask Number: " + taskNumberCounter +
               "\nTask Name: " + taskName +
               "\nTask Description: " + taskDescription +
               "\nTask ID: " + taskId +
               "\nDuration: " + duration + " hours";
    }

    // Method to get the duration
    public int returnTotalHours() {
        return duration;
    }
    
}
    

