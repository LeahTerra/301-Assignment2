package com.example.assignment2;

import java.util.ArrayList;

//--------------------------------------------------------------------------------------------------
// The Task object represents, well, a task.
// Its can be assigned members to work on it and allows other functions to check who is on it
//
// |  Task()
// |\ addMember(assignedMember): Adds a member to assigned members
// |\ returnMembers(): Returns all members working on the current task
// |\ getTitle(): Returns title of the task
// |\ getDependency(): Returns dependency for the task
//
//--------------------------------------------------------------------------------------------------

public class Task {

    private String title;
    private Integer effortEstimate;
    private Task taskDependency;
    private ArrayList<Member> taskMembers;

    public Task(String title, Integer effortEstimate, Task taskDependency) {
        this.title = title;
        this.effortEstimate = effortEstimate;
        this.taskDependency = taskDependency;
        this.taskMembers = new ArrayList<Member>();
    }

    public void addMember(Member assignedMember) {
        taskMembers.add(assignedMember);
    }

    public String getTitle() {
        return this.title;
    }

    public Task getDependency() {
        return this.taskDependency;
    }

    public ArrayList<Member> returnMembers() {
        return this.taskMembers;
    }

}
