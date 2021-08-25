package com.example.secondapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity { // МэинАктивити хранит код и наследует метод AppCompat
    RecyclerView recyclerView;//создаём переменную recyclerView, RecyclerView создаёт динамические списки
    UserAdapter userAdapter;//создаём переменную recyclerView userAdapter
    ArrayList<User> userList = new ArrayList<>();//массив списка пользователей
    Button addUserBtn;

    @Override//переопределяем метод
    protected void onCreate(Bundle savedInstanceState) {//метод срабатывающий при запуске программы
        super.onCreate(savedInstanceState);//обращаемся к savedInstanceState через onCreate
        setContentView(R.layout.activity_main);// определяем отоброжать приложение через activity_main
        //for (int i = 0; i < 100; i++) {
            //userList.add("Пользователь "+i);
            //создаём цикл, который наполняет массив списка Пользователями от 1 до 99
        addUserBtn = findViewById(R.id.addUserBtn);
        recyclerView = findViewById(R.id.recyclerView);// находим recyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));//устанавливаем линейное отображение списка, через MainActivity
        userAdapter = new UserAdapter(userList);// UserAdapter для отображения информации на экране. В данном случае списко пользователей userList
        recyclerView.setAdapter(userAdapter); // передаём данные из userAdapter в recyclerView
        addUserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddUserActivity.class);
                startActivity(intent);
            }
        });
    }
    private void recyclerViewInit(){
        Users users = new Users(MainActivity.this);
        userList = users.getUserList();
        userAdapter = new UserAdapter(userList);
        recyclerView.setAdapter(userAdapter);
    }

    @Override
    public void onResume(){
        super.onResume();
        recyclerViewInit();
    }

    private class UserHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView itemTextView;
        User user;
        public UserHolder(LayoutInflater inflater, ViewGroup viewGroup) {
            super(inflater.inflate(R.layout.single_item, viewGroup, false));
            itemTextView = itemView.findViewById(R.id.itemTextView);
            itemView.setOnClickListener(this);
        }
        public void bind(String userName, User user){
            this.user = user;
            itemTextView.setText(userName);
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, UserInfoActivity.class);
            intent.putExtra("user", user);
            startActivity(intent);
        }
    }

    private class UserAdapter extends RecyclerView.Adapter<UserHolder>{
        ArrayList<User> users;

        public UserAdapter(ArrayList<User> users) {
            this.users = users;
        }

        @Override
        public UserHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
            return new UserHolder(inflater, parent);
        }

        @Override
        public void onBindViewHolder(UserHolder userHolder, int position) {
            User user = users.get(position);
            String userString = user.getUserName()+"\n"+user.getUserLastName();
            userHolder.bind(userString, user);
        }

        @Override
        public int getItemCount() {
            return users.size();
        }
    }
}