package com.example.assignment2;

import java.util.ArrayList;

//--------------------------------------------------------------------------------------------------
// The controller manages everything and provides an aggregation of functions
//
// |  Controller()
// |\ createTask(title, effortEst, taskDepen): Uses TaskManager object to create a task
// |\ assignTask(assigningTask, members): Uses TaskManager to assign task to members
// |\ completeTask(compTask): Uses TaskManager to mark tasks complete. If task has dependency, it
// |                  returns a string denoting which task must be completed prior to this one.
// |\ createMember(name): Uses Team to create new Member
// |\ removeMember(remMember): Uses Team to remove member. Hehe, get it? remEmber? Punny.
// |\ returnMembers(): Uses Team to return full list of members
// |\ getTask(title): Returns task object that has the specified title
// |\ getMember(name): Returns member object of the specified name
// |\ returnTasks(): Uses TaskManager to return full list of tasks
//
//--------------------------------------------------------------------------------------------------

public class Controller {

    private Team team;
    private TaskManager manager;

    public Controller() {
        team = new Team();
        manager = new TaskManager();
    }

    public void createTask(String title, Integer effortEst, Task taskDepen) {
        this.manager.createTask(title, effortEst, taskDepen);
    }

    public void assignTask(Task assigningTask, ArrayList<Member> members) {
        this.manager.assignTask(assigningTask, members);
    }

    public String completeTask(Task compTask) {
        String response = this.manager.completeTask(compTask);
        return response;
    }

    public void createMember(String name) {
        this.team.createMember(name);
    }

    public void removeMember(Member remEmber) {
        this.team.removeMember(remEmber);
    }

    public ArrayList<Member> returnMembers() {
        return this.team.returnMembers();
    }

    public Task getTask(String title) {
        Task tempTask = this.manager.getTask(title);
        if(tempTask != null) {
            return tempTask;
        }
        return null;
    }

    public Member getMember(String name) {
        Member tempMember = this.team.getMember(name);
        if(tempMember != null) {
            return tempMember;
        }
        return null;
    }

    public ArrayList<Task> returnTasks() {
        return this.manager.returnTasks();
    }

}
