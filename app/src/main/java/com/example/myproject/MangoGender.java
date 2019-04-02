package com.example.myproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MangoGender extends AppCompatActivity {
    RadioGroup radioGroup;
    RadioButton radioButton;
    Button mangoid;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mango);
       radioGroup =(RadioGroup)findViewById(R.id.radioid);
        mangoid =(Button)findViewById(R.id.mangoid);

        mangoid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                int selectedId = radioGroup.getCheckedRadioButtonId();
                radioButton =(RadioButton)findViewById(selectedId);
                String firstname = getIntent().getStringExtra("Firstname");
                String lastname = getIntent().getStringExtra("Lastname");
                String email = getIntent().getStringExtra("Email");
                String talkid = getIntent().getStringExtra("TalkId");

                String radiobutton = radioButton.getText().toString();

                MangoExtra(firstname, lastname,email,talkid,radiobutton);

            }
        });

        }
        public void MangoExtra(String firstname, String lastname,String email, String talkid, String radiobutton){
            updateStatus();
            Intent mango = new Intent(MangoGender.this,BornDate.class);
            mango.putExtra("Firstname",firstname);
            mango.putExtra("Lastname",lastname);
            mango.putExtra("Email",email);
            mango.putExtra("TalkId",talkid);

            mango.putExtra("radiobutton",radiobutton);
            startActivity(mango);
        }
        public void updateStatus(){
        String status;
       if (radioGroup.getCheckedRadioButtonId()== R.id.man){
           status="man";
       }else {
           status="woman";
       }

        }

    }

