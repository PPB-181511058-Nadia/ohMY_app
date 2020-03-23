package com.example.ohmy;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Task.class}, version = 2, exportSchema = false)
public abstract class ohmyTask extends RoomDatabase {
    public abstract TaskDao taskDao();

    private static volatile ohmyTask INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static ohmyTask getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (ohmyTask.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), ohmyTask.class, "ohmy_db").build();
                }
            }
        }
        return INSTANCE;
    }
}
