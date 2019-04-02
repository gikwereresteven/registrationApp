package com.example.myproject;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

public class MangoWelcome extends AppCompatActivity {
    Button connection;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.creationwelcome);
        connection = (Button)findViewById(R.id.connexion);

    }

}
