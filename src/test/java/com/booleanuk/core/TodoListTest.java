package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TodoListTest {
    @Test
    public void exampleTest() {
        String hello = "Hello";
        Assertions.assertEquals("Hello", hello);
        Assertions.assertNotEquals("Goodbye", hello);
    }

    @Test
    public void addTaskCorrect() {
        TodoList list = new TodoList();
        Assertions.assertTrue(list.addTask("do dishes"));
    }

    @Test
    public void addTaskIncorrect() {
        TodoList list = new TodoList();
        Assertions.assertFalse(list.addTask(""));
        list.addTask("dishes");
        Assertions.assertFalse(list.addTask("dishes"));
    }

    @Test
    public void getTodoList(){
        TodoList list = new TodoList();
        Assertions.assertEquals(0, list.getTodoList().size());
        list.addTask("dishes");
        Assertions.assertEquals(1, list.getTodoList().size());
    }


    @Test
    public void setDone() {
        TodoList list = new TodoList();
        Assertions.assertFalse(list.setDone("dishes"));
        list.addTask("dishes");
        Assertions.assertTrue(list.setDone("dishes"));
        Assertions.assertTrue(list.setDone("dishes"));
    }

    @Test
    public void getCompletedTasks(){
        TodoList list = new TodoList();
        list.addTask("dishes");
        Assertions.assertEquals(0, list.getCompletedTasks().size());
        list.setDone("dishes");
        list.addTask("coding");
        Assertions.assertEquals(1, list.getCompletedTasks().size());
        list.setDone("coding");
        Assertions.assertEquals(2, list.getCompletedTasks().size());
    }

    @Test
    public void getIncompletedTasks(){
        TodoList list = new TodoList();
        Assertions.assertEquals(0, list.getIncompletedTasks().size());
        list.addTask("dishes");
        Assertions.assertEquals(1, list.getIncompletedTasks().size());
        list.setDone("dishes");
        Assertions.assertEquals(0, list.getIncompletedTasks().size());
        list.addTask("coding");
        list.addTask("work");
        Assertions.assertEquals(2, list.getIncompletedTasks().size());
    }

    @Test
    public void findTask() {
        TodoList list = new TodoList();
        Assertions.assertEquals("Task not found", list.findTask("dishes"));
        list.addTask("dishes");
        list.addTask("work");
        Assertions.assertEquals("Task found", list.findTask("dishes"));
        Assertions.assertEquals("Task found", list.findTask("work"));
        Assertions.assertEquals("Task not found", list.findTask("walk"));

    }

    @Test
    public void removeTask() {
        TodoList list = new TodoList();
        Assertions.assertFalse(list.removeTask("sepuku"));
        list.addTask("dishes");
        Assertions.assertTrue(list.removeTask("dishes"));
    }

    @Test
    public void getSortedTasksAsc() {
        TodoList list = new TodoList();
        Assertions.assertEquals(0, list.getSortedTasks(true).size());
        list.addTask("apple");
        list.addTask("coconut");
        list.addTask("beach day");
        var returnedList = list.getSortedTasks(true);
        Assertions.assertEquals(3, returnedList.size());
        Assertions.assertEquals("apple", returnedList.getFirst().getKey());
        Assertions.assertEquals("beach day", returnedList.get(1).getKey());
        Assertions.assertEquals("coconut", returnedList.get(2).getKey());
    }

    @Test
    public void getSortedTasksDsc() {
        TodoList list = new TodoList();
        Assertions.assertEquals(0, list.getSortedTasks(false).size());
        list.addTask("apple");
        list.addTask("coconut");
        list.addTask("beach day");
        var returnedList = list.getSortedTasks(false);
        Assertions.assertEquals(3, returnedList.size());
        Assertions.assertEquals("apple", returnedList.get(2).getKey());
        Assertions.assertEquals("beach day", returnedList.get(1).getKey());
        Assertions.assertEquals("coconut", returnedList.get(0).getKey());
    }





}
