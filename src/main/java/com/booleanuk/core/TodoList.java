package com.booleanuk.core;

import java.util.*;

public class TodoList {

    HashMap<String, Boolean> todoList;
    public TodoList() {
        todoList = new HashMap<>();
    }

    public boolean addTask(String taskName) {
        if (taskName.isBlank())
            return false;

        if (todoList.containsKey(taskName))
            return false;

        todoList.put(taskName, false);
        return true;
    }

    public HashMap<String, Boolean> getTodoList() {
        return todoList;
    }

    public boolean setDone(String taskName) {
        if (todoList.containsKey(taskName)) {
            todoList.replace(taskName, true);
            return true;
        }

        return false;
    }

    public HashMap<String, Boolean> getCompletedTasks(){
        return getTasks(true);
    }

    public HashMap<String, Boolean> getIncompletedTasks() {
        return getTasks(false);
    }

    public HashMap<String, Boolean> getTasks(boolean taskStatus) {
        HashMap<String, Boolean> returnTasks = new HashMap<>();
        for (String taskName : todoList.keySet()) {
            if (todoList.get(taskName) == taskStatus) {
                returnTasks.put(taskName, false);
            }
        }
        return returnTasks;

    }

    public String findTask(String taskName) {
        return todoList.containsKey(taskName) ? "Task found" : "Task not found";
    }

    public boolean removeTask(String taskName) {
        return (todoList.remove(taskName)!= null) ;
    }

    public List<Map.Entry<String, Boolean>> getSortedTasks(boolean ascending) {
        List<Map.Entry<String, Boolean>> returnList = new ArrayList<>(todoList.entrySet());
        if (ascending) {
            returnList.sort((a, b) ->  a.getKey().compareTo( b.getKey() ));
        } else {
            returnList.sort((a, b) ->  b.getKey().compareTo( a.getKey() ));
        }

        return returnList;
    }

}
