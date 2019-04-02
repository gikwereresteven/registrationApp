package com.example.myproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MangoProfile extends AppCompatActivity {
    ImageView profileimage;
    Button nextprofile;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.creationprofile);
        profileimage = (ImageView)findViewById(R.id.profile);
        nextprofile = (Button)findViewById(R.id.nexpic);

        nextprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MangoProfile.this,MangoPicture.class);
                startActivity(intent);
            }
        });

    }
}
