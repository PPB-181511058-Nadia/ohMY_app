package com.example.ohmy;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "task")
public class Task {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;

    @ColumnInfo(name="taskName")
    private String taskName;

    @ColumnInfo(name="dueDate")
    private String dueDate;

    @ColumnInfo(name="isdone")
    private boolean isDone;

    //private String infoTask;
//
//    public Task(String taskName, String dueDate, boolean isDone){
//        this(taskName, dueDate, isDone, 0);
//    }
    public Task(String taskName, String dueDate){
        this(taskName, dueDate, false);
    }
    @Ignore
    public Task(String taskName, String dueDate, boolean isDone){
        this(taskName,dueDate,isDone,0);
    }
    @Ignore
    public Task(String taskName, String dueDate, boolean isDone, int id) {
        this.taskName = taskName;
        this.dueDate = dueDate;
        this.isDone = isDone;
        this.id = id;
        //this.infoTask = infoTask;
    }

    public String getTaskName () {
        return taskName;
    }
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
    public String getDueDate() {
        return dueDate;
    }
    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
    public Task getTask(){
        return this;
    }

    public boolean isDone(){
        return isDone;
    }
    public void setDone(boolean done){
        this.isDone = done;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
//

//

//

//
//    public String getInfoTask() {
//        return infoTask;
//    }
//
//    public void setInfoTask(String infoTask) {
//        this.infoTask = infoTask;
//    }
}
