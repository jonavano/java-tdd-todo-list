package com.booleanuk.extension;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TodoListExtension {

        int lastestId ;
        List<Task> todoList;

        public TodoListExtension() {
            todoList = new ArrayList<>();
            lastestId = 0;
        }

        public int getIndexOf(String taskName) {
            for (int i  = 0; i<todoList.size(); i++) {
                if (todoList.get(i).getTaskName().equals(taskName)) {
                    return i;
                }
            }
            return -1;
        }

    public int getIndexOf(int id) {
        for (int i  = 0; i<todoList.size(); i++) {
            if (todoList.get(i).id == id) {
                return i;
            }
        }
        return -1;
    }

        public boolean addTask(String taskName) {
            if (taskName.isBlank())
                return false;

            if (todoList.stream().anyMatch(x -> x.getTaskName().equals(taskName)))
                return false;

            todoList.add(new Task(lastestId++, taskName));
            return true;
        }

        public List<Task> getTodoList() {
            return todoList;
        }

        public boolean setDone(String taskName) {
            int index = getIndexOf(taskName);
            if (index != -1) {
                Task task = todoList.get(index);
                task.setDone();
                return true;
            }
            return false;
        }

    public boolean setDone(int id) {
        int index = getIndexOf(id);
        if (index != -1) {
            Task task = todoList.get(index);
            task.setDone();
            return true;
        }
        return false;
    }

        public List<Task> getCompletedTasks(){
            return getTasks(true);
        }

        public List<Task> getIncompletedTasks() {
            return getTasks(false);
        }

        private List<Task> getTasks(boolean taskStatus) {
            List<Task> returnTasks = new ArrayList<>();
            for (Task task : todoList) {
                if (task.isDone == taskStatus) {
                    returnTasks.add(task);
                }
            }
            return returnTasks;

        }

        public String findTask(String taskName) {
            return (getIndexOf(taskName) != -1) ? "Task found" : "Task not found";
        }

        public boolean removeTask(String taskName) {
            int index = getIndexOf(taskName);
            if (index != -1) {
                todoList.remove(index);
                return true;
            }
            return false ;
        }

        public List<Task> getSortedTasks(boolean ascending) {
//            List<Map.Entry<String, Boolean>> returnList = new ArrayList<>(todoList.entrySet());
            if (ascending) {
                todoList.sort((a, b) ->  a.getTaskName().compareTo( b.getTaskName() ));
            } else {
                todoList.sort((a, b) ->  b.getTaskName().compareTo( a.getTaskName() ));
            }

            return todoList;
        }

        public boolean updateName(int id, String taskName) {
             int index = getIndexOf(id);
                if (index != -1) {
                    Task task = todoList.get(index);
                    task.setTaskName(taskName);
                    return true;
                }

            return false;
        }

    }





