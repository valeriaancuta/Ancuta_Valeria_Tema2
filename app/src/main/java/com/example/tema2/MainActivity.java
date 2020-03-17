package com.example.tema2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MyRecyclerViewAdapter adapter;
    private Button addUser;
    private Button deleteUser;
    private EditText nume;
    private EditText nota;
    ArrayList<User> users = new ArrayList<>();
    private UserRepo repo;
    private LiveData<List<User>> userRoom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initVars();
        initRecyclerView();
    }

    private void initVars(){
        addUser = findViewById(R.id.add);
        deleteUser = findViewById(R.id.delete);
        nume = findViewById(R.id.nume);
        nota = findViewById(R.id.nota);

        addUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addUserToRecycler();
            }
        });

        deleteUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteUserFromRecycler();
            }
        });

        repo = new UserRepo(getApplication());

        //Room test
        User user = new User();
        user.setName("Room");
        user.setMark("RoomNOta");
        repo.insert(user);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                userRoom = repo.getAll();
                Log.e("TAG",userRoom.getValue().get(0).getName());
            }
        }, 10000);
    }

    private void addUserToRecycler(){
        String name_to_add = nume.getText().toString();
        String mark_to_add = nota.getText().toString();
        User user = new User();
        user.setName(name_to_add);
        user.setMark(mark_to_add);
        users.add(user);
        adapter.notifyDataSetChanged();
    }

    private void deleteUserFromRecycler(){
        String name_to_delete = nume.getText().toString();
        String mark_to_delete = nota.getText().toString();
        for(User user: users){
            if (user.getName().equals(name_to_delete) && user.getMark().equals(mark_to_delete)){
                users.remove(user);
                adapter.notifyDataSetChanged();
                break;
            }
        }
    }

    private void initRecyclerView(){
        User user = new User();

        user.setMark("7");
        user.setName("Pavel");
        users.add(user);

        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyRecyclerViewAdapter(this, users);
        recyclerView.setAdapter(adapter);
    }
}
