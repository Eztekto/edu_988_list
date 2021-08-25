package com.example.secondapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UserInfoActivity extends AppCompatActivity {
    private TextView userNameTextView;
    private TextView phoneTextView;
    private User user;
    private Button editUserDataBtn;
    private Button deleteUserBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        userNameTextView = findViewById(R.id.userNameTextView);
        phoneTextView = findViewById(R.id.phoneTextView);
        user = (User) getIntent().getSerializableExtra("user");
        userNameTextView.setText(user.getUserName()+"\n"+user.getUserLastName());
        phoneTextView.setText(user.getPhone());
        editUserDataBtn = findViewById(R.id.editUserDataBtn);
        deleteUserBtn = findViewById(R.id.deleteUserBtn);
        editUserDataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Открываем активность для редактирования пользователя
                // На активность нужно передать данные пользователя (Используйте сериализацию)
                // На активности реализуем возможность изменить данные пользователя
            }
        });
        deleteUserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Реализовать удаление пользователя
                // Возврат на главный экран
            }
        });
    }
}