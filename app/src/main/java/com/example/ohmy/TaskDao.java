package com.example.ohmy;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
import java.util.ArrayList;

@Dao
public interface TaskDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Task task);

    @Query("DELETE FROM task")
    void deleteAll();

    @Query("SELECT * from task ORDER BY dueDate ASC")
    LiveData<List<Task>> getTasks();

    @Update(onConflict = OnConflictStrategy.IGNORE)
    void update(Task task);
}
