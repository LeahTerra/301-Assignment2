package com.example.assignment2;

import java.lang.reflect.Constructor;
import java.util.ArrayList;

//--------------------------------------------------------------------------------------------------
// The TaskManager object manages all task related activities
// Its responsibilities include creating tasks, assigning tasks, and removing tasks on completion
//
// | TaskManager()
// |\ createTask(title, effortEst, taskDepen): Creates new task and adds to task list
// |\ completeTask(remTask): Checks if task dependency is done, if so it removes from members tasks
// |                      if not, it returns a string saying x task must be completed first.
// |
// |\ assignTask(asTask, members): Assigns task to all members in list
// |\ returnTasks(): Returns all current tasks
//
//--------------------------------------------------------------------------------------------------

public class TaskManager {

    private ArrayList<Task> taskList;

    public TaskManager() {
        this.taskList = new ArrayList<>();
    }

    public void createTask(String title, Integer effortEst, Task taskDepen) {
        Task newTask = new Task(title, effortEst, taskDepen);
        taskList.add(newTask);
    }

    public String completeTask(Task compTask) {
        this.taskList.remove(compTask);
        ArrayList<Member> remTaskMembers = compTask.returnMembers();
        if (compTask.getDependency() != null && this.taskList.contains(compTask.getDependency())) {
            String message = "You must complete " + compTask.getDependency().getTitle() + " first!";
            return message;
        }
        else {
            for(int i = 0; i < remTaskMembers.size(); i++) {
                remTaskMembers.get(i).completeTask(compTask);
            }
            return null;
        }
    }

    public void assignTask(Task asTask, ArrayList<Member> members) {
        for(int i = 0; i < members.size(); i++) {
            asTask.addMember(members.get(i));
            members.get(i).assignTask(asTask);
        }
    }

    public Task getTask(String title) {
        ArrayList<Task> taskList = this.taskList;
        for(int i = 0; i < taskList.size(); i++) {
            if(taskList.get(i).getTitle() == title) {
                return taskList.get(i);
            }
        }
        return null;
    }


    public ArrayList<Task> returnTasks() {
        return this.taskList;
    }


}
