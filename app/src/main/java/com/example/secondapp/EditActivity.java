package com.example.secondapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {
    EditText editTextEditName;
    EditText editTextEditLastName;
    EditText editTextEditPhone;
    Button formSaveEditBtn;
    private User user;

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(EditActivity.this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        editTextEditName = findViewById(R.id.editTextEditName);
        editTextEditLastName = findViewById(R.id.editTextEditLastName);
        editTextEditPhone = findViewById(R.id.editTextEditPhone);
        formSaveEditBtn = findViewById((R.id.formSaveEditBtn));


        user = (User) getIntent().getSerializableExtra("user");
        editTextEditName.setText(user.getUserName());
        editTextEditLastName.setText(user.getUserLastName());
        editTextEditPhone.setText(user.getPhone());
        formSaveEditBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                user.setUserName(editTextEditName.getText().toString());
                user.setUserLastName(editTextEditLastName.getText().toString());
                user.setPhone(editTextEditPhone.getText().toString());
                Users users = new Users(EditActivity.this);
                users.updateUser(user);

                onBackPressed();
            }
        });
    }
}