package com.example.myproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Pattern;

public class EmailAddress extends AppCompatActivity {

    EditText emailadd;
    Button next;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.emailaddress);
        emailadd =(EditText)findViewById(R.id.idemail);
        next = (Button)findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstname=getIntent().getStringExtra("Firstname");
                String lastname =getIntent().getStringExtra("Lastname");
                String email = emailadd.getText().toString();
                if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    emailadd.setError("Please enter valid email address");

                    if(email.matches("^[A-Za-z]+$")){
                        emailadd.setError("please Email must enter character");

                    }

                }
                else {
                    passData(firstname,lastname,email);
                }

            }

        });

    }
public void passData(String firstname, String lastname,String email ){
    Intent talkid = new Intent(EmailAddress.this,TalkID.class);
    talkid.putExtra("Firstname",firstname);
    talkid.putExtra("Lastname",lastname);
    talkid.putExtra("Email",email);
    startActivity(talkid);

}
}
