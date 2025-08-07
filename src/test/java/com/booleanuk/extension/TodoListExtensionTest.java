package com.booleanuk.extension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.invoke.TypeDescriptor;

public class TodoListExtensionTest {


    @Test
    public void exampleTest() {
        String hello = "Hello";
        Assertions.assertEquals("Hello", hello);
        Assertions.assertNotEquals("Goodbye", hello);
    }

    @Test
    public void addTaskCorrect() {
        TodoListExtension list = new TodoListExtension();
        Assertions.assertTrue(list.addTask("do dishes"));
    }

    @Test
    public void addTaskIncorrect() {
        TodoListExtension list = new TodoListExtension();
        Assertions.assertFalse(list.addTask(""));
        list.addTask("dishes");
        Assertions.assertFalse(list.addTask("dishes"));
    }

    @Test
    public void getTodoListExtension(){
        TodoListExtension list = new TodoListExtension();
        Assertions.assertEquals(0, list.getTodoList().size());
        list.addTask("dishes");
        Assertions.assertEquals(1, list.getTodoList().size());
    }


    @Test
    public void setDone() {
        TodoListExtension list = new TodoListExtension();
        Assertions.assertFalse(list.setDone("dishes"));
        list.addTask("dishes");
        Assertions.assertTrue(list.setDone("dishes"));
        Assertions.assertTrue(list.setDone("dishes"));
    }

    @Test
    public void setDoneId() {
        TodoListExtension list = new TodoListExtension();
        Assertions.assertFalse(list.setDone(0));
        list.addTask("dishes");
        Assertions.assertTrue(list.setDone(0));
        Assertions.assertTrue(list.setDone(0));
    }
//
    @Test
    public void getCompletedTasks(){
        TodoListExtension list = new TodoListExtension();
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
        TodoListExtension list = new TodoListExtension();
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
        TodoListExtension list = new TodoListExtension();
        Assertions.assertEquals("Task not found", list.findTask("dishes"));
        list.addTask("dishes");
        list.addTask("work");
        Assertions.assertEquals("Task found", list.findTask("dishes"));
        Assertions.assertEquals("Task found", list.findTask("work"));
        Assertions.assertEquals("Task not found", list.findTask("walk"));

    }

    @Test
    public void removeTask() {
        TodoListExtension list = new TodoListExtension();
        Assertions.assertFalse(list.removeTask("sepuku"));
        list.addTask("dishes");
        Assertions.assertTrue(list.removeTask("dishes"));
    }

    @Test
    public void getSortedTasksAsc() {
        TodoListExtension list = new TodoListExtension();
        Assertions.assertEquals(0, list.getSortedTasks(true).size());
        list.addTask("apple");
        list.addTask("coconut");
        list.addTask("beach day");
        var returnedList = list.getSortedTasks(true);
        Assertions.assertEquals(3, returnedList.size());
        Assertions.assertEquals("apple", returnedList.getFirst().getTaskName());
        Assertions.assertEquals("beach day", returnedList.get(1).getTaskName());
        Assertions.assertEquals("coconut", returnedList.get(2).getTaskName());
    }

    @Test
    public void getSortedTasksDsc() {
        TodoListExtension list = new TodoListExtension();
        Assertions.assertEquals(0, list.getSortedTasks(false).size());
        list.addTask("apple");
        list.addTask("coconut");
        list.addTask("beach day");
        var returnedList = list.getSortedTasks(false);
        Assertions.assertEquals(3, returnedList.size());
        Assertions.assertEquals("apple", returnedList.get(2).getTaskName());
        Assertions.assertEquals("beach day", returnedList.get(1).getTaskName());
        Assertions.assertEquals("coconut", returnedList.get(0).getTaskName());
    }

    @Test
    public void updateTaskName() {
        TodoListExtension list = new TodoListExtension();
        Assertions.assertFalse(list.updateName(0, "banana"));
        list.addTask("dishes");
        Assertions.assertTrue(list.updateName(0, "banana"));
        Assertions.assertEquals("banana",list.getTodoList().getFirst().getTaskName());

    }
}
