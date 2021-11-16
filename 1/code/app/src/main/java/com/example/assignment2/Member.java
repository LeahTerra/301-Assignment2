package com.example.assignment2;

import java.util.ArrayList;

//--------------------------------------------------------------------------------------------------
// The Member object represents an individual member
// Its can be assigned tasks, complete tasks,
//
// | Member()
// |\ assignTask(newTask): Assigns task to current member by adding to task list
// |\ completeTask(compTask): Removes task from membersTask
// |\ getName(): Returns members name
// |\ returnTasks(): Returns all of members tasks
//
//--------------------------------------------------------------------------------------------------

public class Member {

    private String name;
    private ArrayList<Task> memberTasks;

    public Member(String name) {
        this.name = name;
        memberTasks = new ArrayList<Task>();
    }

    public void assignTask(Task newTask) {
        memberTasks.add(newTask);
    }

    public void completeTask(Task compTask) {
        memberTasks.remove(compTask);
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Task> returnTasks() {
        return this.memberTasks;
    }

}
