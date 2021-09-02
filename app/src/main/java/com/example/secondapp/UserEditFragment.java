package com.example.secondapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.secondapp.placeholder.PlaceholderContent;


public class UserEditFragment extends Fragment {

    EditText editTextEditName;
    EditText editTextEditLastName;
    EditText editTextEditPhone;
    Button formSaveEditBtn;
    private User user;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        user = (User) bundle.getSerializable("user");//получаем данные о пользователе, чтобы потом заполнить этими данными фрагмент Редактировать данные
    }

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = layoutInflater.inflate(R.layout.fragment_user_edit, viewGroup, false);
        editTextEditName = view.findViewById(R.id.editTextEditName);
        editTextEditLastName = view.findViewById(R.id.editTextEditLastName);
        editTextEditPhone = view.findViewById(R.id.editTextEditPhone);
        formSaveEditBtn = view.findViewById((R.id.formSaveEditBtn));
        editTextEditName.setText(user.getUserName());
        editTextEditLastName.setText(user.getUserLastName());
        editTextEditPhone.setText(user.getPhone());
        formSaveEditBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                user.setUserName(editTextEditName.getText().toString());
                user.setUserLastName(editTextEditLastName.getText().toString());
                user.setPhone(editTextEditPhone.getText().toString());
                Users users = new Users(getActivity());
                users.updateUser(user);

            }
        });
        return view;

    }
}
