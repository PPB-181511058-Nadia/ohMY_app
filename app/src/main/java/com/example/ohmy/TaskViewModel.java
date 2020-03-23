package com.example.ohmy;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class TaskViewModel extends AndroidViewModel {

    private TaskRepository mRepository;

    private LiveData<List<Task>> allTasks;

    public TaskViewModel (Application application) {
        super(application);
        mRepository = new TaskRepository(application);
        allTasks = mRepository.getAllTasks();
    }

    LiveData<List<Task>> getAllTasks() { return allTasks; }

    public void insert(Task task) { mRepository.insert(task); }
    public void update(Task task) { mRepository.update(task); }

}
