package com.example.myproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ModePasse extends AppCompatActivity {
    EditText editmode;
    Button suivant;
    TextView modepass;
    String passwordholder;
    String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.creationmodepasse);
     editmode =(EditText)findViewById(R.id.modepasse);
     suivant = (Button)findViewById(R.id.suivant);
     modepass = (TextView)findViewById(R.id.createid);

     suivant.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             passwordholder = editmode.getText().toString();
             if (!TextUtils.isEmpty(passwordholder) && passwordholder.matches(PASSWORD_PATTERN)) {
                 ModepasseExtra(passwordholder);

             }else{
                 Toast.makeText(ModePasse.this,"" +
                         "Passwords must be at least 6 characters in length,upper,lower and special character and number Ex:Hars@12.",Toast.LENGTH_LONG).show();
             }

         }
     });


    }

    public void ModepasseExtra( String passwordholder){
        Intent mode= new Intent(ModePasse.this,MangoProfile.class);
        mode.putExtra("Modepasse",passwordholder);
        startActivity(mode);
    }
}
