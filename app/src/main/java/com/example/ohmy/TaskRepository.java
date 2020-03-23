package com.example.ohmy;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class TaskRepository {
    private TaskDao taskDao;
    private LiveData<List<Task>> allTasks;


    TaskRepository(Application application) {
        ohmyTask db = ohmyTask.getDatabase(application);
        taskDao = db.taskDao();
        allTasks = taskDao.getTasks();
    }

    LiveData<List<Task>> getAllTasks() {
        return allTasks;
    }

    void insert(Task task) {
        ohmyTask.databaseWriteExecutor.execute(() -> {
            taskDao.insert(task);
        });
    }
    void update(Task task) {
        ohmyTask.databaseWriteExecutor.execute(() -> {
            taskDao.update(task);
        });
    }


}
