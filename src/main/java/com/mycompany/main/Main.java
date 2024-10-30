/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.main;
import javax.swing.JOptionPane;
import java.util.ArrayList;

/**
 *
 * @author Muthivhi_Tshedza
 */
public class Main {
    private static ArrayList<Task> tasks = new ArrayList<>();
    private static Login login = new Login();
    private static int totalHours = 0;

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");

        // User Registration
        String username = JOptionPane.showInputDialog("Enter username:");
        String password = JOptionPane.showInputDialog("Enter password:");
        String firstName = JOptionPane.showInputDialog("Enter first name:");
        String lastName = JOptionPane.showInputDialog("Enter last name:");

        String registrationMessage = login.registerUser(username, password, firstName, lastName);
        JOptionPane.showMessageDialog(null, registrationMessage);

        // User Login
        username = JOptionPane.showInputDialog("Login username:");
        password = JOptionPane.showInputDialog("Login password:");

        String loginMessage = login.loginUser(username, password);
        JOptionPane.showMessageDialog(null, loginMessage);

        if (loginMessage.startsWith("Welcome")) {
            boolean running = true;

            while (running) {
                String options = "1. Add tasks\n2. Show report (Coming Soon)\n3. Quit";
                String choice = JOptionPane.showInputDialog(options);
                
                switch (choice) {
                    case "1":
                        addTasks();
                        break;
                    case "2":
                        JOptionPane.showMessageDialog(null, "Coming Soon");
                        break;
                    case "3":
                        running = false;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Invalid option. Please choose again.");
                }
            }
        }
    }

    private static void addTasks() {
        int numTasks = Integer.parseInt(JOptionPane.showInputDialog("How many tasks do you wish to enter?"));

        for (int i = 0; i < numTasks; i++) {
            String taskName = JOptionPane.showInputDialog("Enter task name:");
            String taskDescription = JOptionPane.showInputDialog("Enter task description:");
            String developerDetails = JOptionPane.showInputDialog("Enter developer details:");
            int duration = Integer.parseInt(JOptionPane.showInputDialog("Enter task duration (in hours):"));
            String taskStatus = JOptionPane.showInputDialog("Enter task status (to do, done, doing):");

            Task task = new Task(taskName, taskDescription, developerDetails, duration, taskStatus);

            if (task.checkTaskDescription()) {
                tasks.add(task);
                totalHours += task.returnTotalHours();
                JOptionPane.showMessageDialog(null, "Task successfully captured!\n" + task.printTaskDetails());
            } else {
                JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters.");
            }
        }

        JOptionPane.showMessageDialog(null, "Total hours across all tasks: " + totalHours);
    }
        
        
    }

