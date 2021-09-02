package com.example.secondapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;


public class UserAddFragment extends Fragment {


    EditText editTextAddName;
    EditText editTextAddLastName;
    EditText editTextAddPhone;
    Button formAddUserBtn;

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = layoutInflater.inflate(R.layout.fragment_user_add, viewGroup, false);
        editTextAddName = view.findViewById(R.id.editTextEditName);
        editTextAddLastName = view.findViewById(R.id.editTextUserLastName);
        editTextAddPhone = view.findViewById(R.id.editTextPhone);
        formAddUserBtn = view.findViewById(R.id.formAddUserBtn);

        formAddUserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User();
                user.setUserName(editTextAddName.getText().toString());
                user.setUserLastName(editTextAddLastName.getText().toString());
                user.setPhone(editTextAddPhone.getText().toString());
                Users users = new Users(getActivity());
                users.addUser(user);
            }
        });
        return view;
    }
}