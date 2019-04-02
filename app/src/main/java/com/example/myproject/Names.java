package com.example.myproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Names extends AppCompatActivity {
    EditText fname,lname;
    Button nextname;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accauntname);

        fname = (EditText)findViewById(R.id.fname);
        lname = (EditText)findViewById(R.id.lname);
        nextname = (Button)findViewById(R.id.suivant);

        nextname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstname = fname.getText().toString();
                String lastname = lname.getText().toString();
                if (firstname.isEmpty()|| lastname.isEmpty()){
                    fname.setError("Sorry is empty");
                    lname.setError("Sorry is Empty");




                }

                else if (!firstname.matches("^[A-Za-z]+$") || !lastname.matches("^[A-Za-z]+$" )){
                    fname.setError("please enter valid FirstName");
                    lname.setError("Please enter valid LastName");

                }
                else {
                    ValidateName(firstname,lastname);

                }

               }
        });

    }
    public void ValidateName(String firstname, String lastname){

        Intent i = new Intent(Names.this,EmailAddress.class);
        i.putExtra("Firstname",firstname);
        i.putExtra("Lastname",lastname);
        startActivity(i);

    }
}
