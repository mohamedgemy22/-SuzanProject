package com.enggemy22.myapplication;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class account extends Fragment {
private EditText meditTextName;
private EditText medEditTextPassword;
private Button mbutton;
View view;

    public account() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_account, container, false);
        meditTextName=view.findViewById(R.id.useer_name);
        medEditTextPassword=view.findViewById(R.id.password);
        mbutton=view.findViewById(R.id.logIn);

        mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name= meditTextName.getText().toString();
                String pssword=medEditTextPassword.getText().toString();
                if (name.equalsIgnoreCase("khaled") && pssword.equalsIgnoreCase("12345")){
                    Intent intent=new Intent(getActivity().getApplicationContext(),RetriveData.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getActivity().getApplicationContext(),"معزرة لايمكنك الدخول هنها خاصة بالدكتور فقط ",Toast.LENGTH_LONG).show();
                }

            }
        });
        return view;
    }

}
