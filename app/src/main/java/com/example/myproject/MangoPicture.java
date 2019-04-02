package com.example.myproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MangoPicture extends AppCompatActivity {

    Button welcome;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.creationpicture);
        welcome = (Button)findViewById(R.id.nexpic);

        welcome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ine = new Intent(MangoPicture.this,MangoWelcome.class);
            }
        });

    }
}
