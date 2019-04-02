package com.example.myproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TalkID extends AppCompatActivity {
    EditText talkname;
    Button nextdate;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.talkid);
        talkname = (EditText)findViewById(R.id.id);
        nextdate = (Button)findViewById(R.id.nextid);


        nextdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstname = getIntent().getStringExtra("Firstname");
                String lastname = getIntent().getStringExtra("Lastname");
                String email = getIntent().getStringExtra("Email");
                String talkid= talkname.getText().toString();
                if(talkid.isEmpty() || !talkid.matches("^[A-Za-z]+$")){
                    talkname.setError("Please enter valid TalkId");
                }
                else {
                    TalkExtra(firstname,lastname,email,talkid);
                }

            }
        });


    }
    public void TalkExtra(String firstname, String lastname, String email, String talkid){
        Intent talk = new Intent(TalkID.this,MangoGender.class);
        talk.putExtra("Firstname",firstname);
        talk.putExtra("Lastname",lastname);
        talk.putExtra("Email",email);
        talk.putExtra("TalkId",talkid);
        startActivity(talk);

    }
}
