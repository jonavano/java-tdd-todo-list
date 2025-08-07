package com.booleanuk.extension;

import java.time.LocalDateTime;
import java.util.Date;

public class Task {
    int id;
    String taskName;
    boolean isDone;
    LocalDateTime creationDate ;

    public Task(int id, String taskName) {
        this.id = id;
        this.taskName = taskName;
        isDone = false;
        creationDate = LocalDateTime.now();
    }

    public String getTaskName() {
        return this.taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setDone() {
        this.isDone = true;
    }
        
    
    }
