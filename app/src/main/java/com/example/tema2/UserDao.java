package com.example.tema2;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM User")
    LiveData<List<User>> getAll();

    @Insert
    void insert(User user);

}
