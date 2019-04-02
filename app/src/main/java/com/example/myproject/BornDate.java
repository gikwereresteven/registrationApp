package com.example.myproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class BornDate extends AppCompatActivity {

    DatePicker bornday;
    Button nextborn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.creationdate);

        bornday = (DatePicker)findViewById(R.id.simpleDatePicker);
        nextborn =(Button)findViewById(R.id.nextborn);

        nextborn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // get the values for day of month , month and year from a date picker
                String  day = "Day = " + bornday.getDayOfMonth();
                String month = "Month = " + (bornday.getMonth() + 1);
                String year = "Year = " + bornday.getYear();
                //display the values by using a toast
               // Toast.makeText(getApplicationContext(), day + "\n" + month + "\n" + year, Toast.LENGTH_LONG).show();


                String firstname = getIntent().getStringExtra("Firstname");
                String lastname = getIntent().getStringExtra("Lastname");
                String email = getIntent().getStringExtra("Email");
                String talkid = getIntent().getStringExtra("TalkId");
                String radiobutton = getIntent().getStringExtra("radiobutton");
                Date myDate = new Date(bornday.getDayOfMonth(), bornday.getMonth(), bornday.getYear());
                datateMethod (firstname,lastname,email,talkid,radiobutton,myDate);

            }
        });


    }
    public void datateMethod (String firstname, String lastname, String email, String talkid, String radiobutton, Date myDate){
        Intent datepicker = new Intent(BornDate.this,PasswordConfirmed.class);
        datepicker.putExtra("Firstname",firstname);
        datepicker.putExtra("Lastname",lastname);
        datepicker.putExtra("Email",email);
        datepicker.putExtra("TalkId",talkid);
        datepicker.putExtra("radiobutton",radiobutton);
        datepicker.putExtra("dob", myDate.toString());
        // datepicker.putExtra("Date", day +"/"+month+"/"+year+"+");
        //Intent mango = getIntent();
        //int checked = mango.getIntExtra("checked");
        startActivity(datepicker);

    }
}
