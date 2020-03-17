package com.example.tema2;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class UserRepo {
    private UserDao userDao;
    private LiveData<List<User>> users;

    public UserRepo(Application application){
        DB database = DB.getInstance(application);
        userDao = database.userDao();
        users = userDao.getAll();
    }

    public void insert(User user){
        new InsertAsyncTask(userDao).execute(user);
    }

    public LiveData<List<User>> getAll(){
        return users;
    }

    private static class InsertAsyncTask extends AsyncTask<User,Void,Void> {
        private UserDao userDao;

        private InsertAsyncTask(UserDao userDao){
            this.userDao = userDao;
        }

        @Override
        protected Void doInBackground(User... users) {
            userDao.insert(users[0]);
            return null;
        }
    }
}
