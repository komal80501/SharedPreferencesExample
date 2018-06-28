package com.example.student_006.sharedpreferencesexample;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
SharedPreferences sharedPreferences;
TextView name;
TextView email;
public static String mpreference="mypref";
public static String Name="nameKey";
public static String Email="emailKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (TextView) findViewById(R.id.txtname);
        email = (TextView) findViewById(R.id.txtemail);
        sharedPreferences = getSharedPreferences(mpreference, Context.MODE_PRIVATE);

        if (sharedPreferences.contains(Name)) {
            name.setText(sharedPreferences.getString(Name, ""));
        }
        if (sharedPreferences.contains(Email)) {
            email.setText(sharedPreferences.getString(Email, ""));
        }
    }

    public void retrive(View view) {
        name=(TextView) findViewById(R.id.txtname);
        email=(TextView) findViewById(R.id.txtemail);
        sharedPreferences= getSharedPreferences(mpreference,Context.MODE_PRIVATE);

        if (sharedPreferences.contains(Name)) {
            name.setText(sharedPreferences.getString(Name, ""));
        }
        if (sharedPreferences.contains(Email)) {
            email.setText(sharedPreferences.getString(Email, ""));
        }
    }


    public void clear(View view) {
    name=(TextView) findViewById(R.id.txtname);
    email=(TextView) findViewById(R.id.txtemail);
        name.setText("");
        email.setText("");

    }

    public void save(View view) {
        String n =name.getText().toString();
        String e =email.getText().toString();
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString(Name,n);
        editor.putString(Email,e);
        editor.apply();
    }
}
