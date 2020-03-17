package com.example.tema2;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = User.class, version  = 2)
public abstract class DB extends RoomDatabase {
    private static DB instance;
    public abstract UserDao userDao();

    public static synchronized DB getInstance(Context ctx){
        if(instance==null){
            instance = Room.databaseBuilder(ctx.getApplicationContext(),
                     DB.class,"user")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }

}
