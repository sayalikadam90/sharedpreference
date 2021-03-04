package com.example.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtName,edtLastName;
    Button btnsave,btnget;
    public String SharedName="ASCII";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtName=findViewById(R.id.edtName);
        edtLastName=findViewById(R.id.edtlastName);
        btnsave=findViewById(R.id.btnsave);
        btnget=findViewById(R.id.btnget);

        @SuppressLint("WrongConstant") SharedPreferences sharedPreferences=getSharedPreferences(SharedName, Context.MODE_APPEND);
        SharedPreferences .Editor editor=sharedPreferences.edit();

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString("Fname",edtName.getText().toString().trim());
                editor.putString("Lname",edtLastName.getText().toString().trim());
                Toast.makeText(MainActivity.this,"Thanks Data is saved successfully...",Toast.LENGTH_LONG).show();
                editor.commit();
                edtName.setText("");
                edtLastName.setText("");

            }
        });

        btnget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtName.setText(sharedPreferences.getString("Fname","Name"));
                edtLastName.setText(sharedPreferences.getString("Lname","Last Name"));

            }
        });
    }
}