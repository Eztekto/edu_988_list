package com.example.seconndapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity { // МэинАктивити хранит код и наследует метод AppCompat
    RecyclerView recyclerView;//создаём переменную recyclerView, RecyclerView создаёт динамические списки
    UserAdapter userAdapter;//создаём переменную recyclerView userAdapter
    ArrayList<String> userList = new ArrayList<>();//массив списка пользователей

    @Override//переопределяем метод
    protected void onCreate(Bundle savedInstanceState) {//метод срабатывающий при запуске программы
        super.onCreate(savedInstanceState);//обращаемся к savedInstanceState через onCreate
        setContentView(R.layout.activity_main);// определяем отоброжать приложение через activity_main
        for (int i = 0; i < 100; i++) {
            userList.add("Пользователь "+i);
            //создаём цикл, который наполняет массив списка Пользователями от 1 до 99
        }

        recyclerView = findViewById(R.id.recyclerView);// находим recyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));//устанавливаем линейное отображение списка, через MainActivity
        userAdapter = new UserAdapter(userList);// UserAdapter для отображения информации на экране. В данном случае списко пользователей userList
        recyclerView.setAdapter(userAdapter); // передаём данные из userAdapter в recyclerView
    }
    private class UserHolder extends RecyclerView.ViewHolder{//создаём класс UserHolder наследующий RecyclerView.ViewHolder
        TextView itemTextView;//переменная для работы с элементами экрана
        public UserHolder(LayoutInflater inflater, ViewGroup viewGroup) {
            super(inflater.inflate(R.layout.single_item, viewGroup, false));//inflater.inflate аннализирует single_item и помещает его в viewGroup не добавляя в корень программы.
            itemTextView = itemView.findViewById(R.id.itemTextView);//находим itemTextView
        }
        public void bind(String userName){
            itemTextView.setText(userName);
        }//передаем имя пользователя в itemTextView
    }

    private class UserAdapter extends RecyclerView.Adapter<UserHolder>{
        ArrayList<String> users; //создаём массив с именами пользователей

        public UserAdapter(ArrayList<String> users) {
            this.users = users;
        }//UserAdapter принимает массив пользователей

        @Override//переопределяем UserHolder
        public UserHolder onCreateViewHolder(ViewGroup parent, int viewType) {//метод для "разудвания" объекта
            LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
            return new UserHolder(inflater, parent);// возвращаем UserHolder(inflater, parent)
        }

        @Override
        public void onBindViewHolder(UserHolder userHolder, int position) {
            String user = users.get(position);//получаем цифровое значение users в списке
            userHolder.bind(user);// связывает userHolder c user
        }

        @Override
        public int getItemCount() {
            return users.size();
        }// определяет сколько элементов получено и сколько нужно отобразить
    }
}