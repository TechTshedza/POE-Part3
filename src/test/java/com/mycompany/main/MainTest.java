/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.main;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Muthivhi Tshedza
 */
public class MainTest {
    
    public MainTest() {
    }
    

    @Test
    public void testUserNameFormatting() {
        Login login = new Login();
        assertTrue(login.checkUserName("kyl_1"));
        assertFalse(login.checkUserName("kyle!!!!!"));
    }

    @Test
    public void testPasswordComplexity() {
        Login login = new Login();
        assertTrue(login.checkPasswordComplexity("Ch&&sec@ke99!"));
        assertFalse(login.checkPasswordComplexity("password"));
    }
    
    @Test
    public void testRegisterUser() {
        Login login = new Login();
        assertEquals("Username and Password successfully captured.", login.registerUser("kyl_1", "Ch&&sec@ke99!", "Kyle", "Smith"));
    }

    @Test
    public void testLoginUser() {
        Login login = new Login();
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "Kyle", "Smith");
        assertEquals("Welcome Kyle, Smith, it is great to see you again.", login.loginUser("kyl_1", "Ch&&sec@ke99!"));
    }
@Test
public void testTaskCreation() {
        Task task = new Task("Login Feature", "Authenticate users", "Mike Smith", 5, "To Do");
        assertTrue(task.checkTaskDescription());
        assertEquals("LI: 1: D", task.createTaskID());
    }

    @Test
    public void testLongestDuration() {
        TaskManager manager = new TaskManager();
        manager.addTask(new Task("Task 1", "Short task", "Dev A", 3, "Done"));
        manager.addTask(new Task("Task 2", "Longer task", "Dev B", 8, "Doing"));
        assertEquals("Dev B, 8", manager.findLongestDuration());
    }
}
