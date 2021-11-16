package com.example.assignment2;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;

//--------------------------------------------------------------------------------------------------
//
//  This unit test is designed for Question 1 of Assignment 2 in CMPUT 301.
//  The methods used are in my Controller object methods, which was designed to create a single
//  object than can serve all the functions require. In it, it creates two object managers:
//      Team: which manages all member activities such as adding or removing members
//      TaskManager: which manages all task activities such as adding, completing, or assigning
//                   tasks.
//
//  To create a task, you call the addTask() method in controller, using inputs from the user to
//  fill parameters title, effort estimate, and dependencies. This calls the addTask method in the
//  TaskManager object that creates a new task object.
//
//  To make a team member, you call the addMember() method in controller, using user input to give
//  the member a name which is its only parameter. This calls the addMember method in the team
//  manager, creating a new member object.
//
//
//  To assign a task, you call the assignTask() method in controller. This has an interesting format
//  in that it requires an arraylist containing 1 or more members. This is done so that using a
//  checklist in UI could provide multiple members being assigned at once, making things more
//  efficient than assigning a single task to multiple members individually. How this works is that
//  it calls TaskManager to assign tasks to members, but also assigning members to tasks. This is so
//  we can see what tasks each member has, and who is working on any given task.
//
//--------------------------------------------------------------------------------------------------


public class ControllerTest {

    private Controller control;


    @Before
    public void setUp() throws Exception {
        control = new Controller();
    }

    // Tests adding task method by checking initial size to be 0, then using the add
    // method in controller, then checking size of task list is == 1.
    @Test
    public void testAddTask() {
        assertEquals(0, control.returnTasks().size());
        control.createTask("Task1", 5, null);
        assertEquals(1, control.returnTasks().size());
    }

    // Tests adding member method by checking initial member size to be 0, then using add member
    // method to create a new one, then checking if it the array contains the member object.
    @Test
    public void testAddMember() {
        assertEquals(0, control.returnMembers().size());
        control.createMember("Leah");
        assertEquals(1, control.returnMembers().size());
    }

    // Tests the assignTask method by creating a task and a member, checking that the task members
    // tasks are 0, then creates an array to contain members that are going to be assigned to the
    // task, and then assign it. I then test whether the member has indeed has the test assigned
    // as well as whether the task registers that as well.
    @Test
    public void testAssignTask() {
        control.createTask("Task1", 5, null);
        control.createMember("Leah");
        // Uses returnTasks method in the Member object, returning an arraylist
        assertTrue(control.getMember("Leah").returnTasks().size() == 0);

        ArrayList<Member> task1Members = new ArrayList<>();
        task1Members.add(control.getMember("Leah"));
        control.assignTask(control.getTask("Task1"), task1Members);

        assertEquals(1, control.getMember("Leah").returnTasks().size());
        assertEquals(1, control.getTask("Task1").returnMembers().size());
    }
}
