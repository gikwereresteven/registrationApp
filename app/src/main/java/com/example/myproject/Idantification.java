package com.example.myproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Idantification extends AppCompatActivity {

EditText  idemail;
Button suivant;
TextView createid;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.idantification);

        idemail =(EditText)findViewById(R.id.idemail);
        suivant=(Button) findViewById(R.id.suivant);
        createid= (TextView)findViewById(R.id.create);

        suivant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent modepasse = new Intent(Idantification.this,ModePasse.class);

            }
        });
createid.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent names = new Intent(Idantification.this,Names.class);
        startActivity(names);
    }
});
suivant.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(Idantification.this,ModePasse.class);
        startActivity(intent);
    }
});

    }
}
