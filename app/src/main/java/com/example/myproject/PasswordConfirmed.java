package com.example.myproject;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class PasswordConfirmed extends AppCompatActivity {
    EditText passwordid;
    EditText confpasswordid;
    Button nextpassword;
    private static final String TAG = MainActivity.class.getName();
    private RequestQueue mRequestQueue;
    private StringRequest mStringRequest;
    String server_url="  https://976c7a5c.ngrok.io";
    String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
    String firstname, lastname, email, talkid, radiobutton, datepicker, password, confpassword;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.passwordcreation);
        passwordid = (EditText)findViewById(R.id.password);
        confpasswordid = (EditText) findViewById(R.id.confirmationpassword);
        nextpassword = (Button)findViewById(R.id.nextpassword);
        nextpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseVolley();
                firstname = getIntent().getStringExtra("Firstname");
                lastname = getIntent().getStringExtra("Lastname");
                email = getIntent().getStringExtra("Email");
                talkid = getIntent().getStringExtra("TalkId");
                radiobutton = getIntent().getStringExtra("radiobutton");
                datepicker = getIntent().getStringExtra("Date");
                password = passwordid.getText().toString();
                confpassword = confpasswordid.getText().toString();
                if (!password.isEmpty() && !confpassword.isEmpty()){
                    if((password.equals(confpassword) && password.matches(PASSWORD_PATTERN))){
                        Toast.makeText(PasswordConfirmed.this,""+firstname+" "+lastname+" "+email+" "+talkid+" "+radiobutton+" "+datepicker+" "+password+" "+confpassword,Toast.LENGTH_LONG).show();
                        insertIntoDatabase(firstname,lastname,email,talkid,radiobutton,datepicker,password,confpassword);
                    }else {
                        Toast.makeText(PasswordConfirmed.this,"" +
                                "Passwords must be at least 6 characters in length,upper,lower and special character and number Ex:Hars@12.",Toast.LENGTH_LONG).show();

                    }
                }
                else {
                    passwordid.setError("please fill password");
                    confpasswordid.setError("please fill confirmation");
                }
            }
        });
    }
    public void insertIntoDatabase(String firstname,String lastname,String email,String talkid, String radiobutton,String datepicker
            ,String password, String confpassword){

        Intent confirm = new Intent(PasswordConfirmed.this,MangoProfile.class);
        confirm.putExtra("Firstname",firstname);
        confirm.putExtra("Lastname",lastname);
        confirm.putExtra("Email",email);
        confirm.putExtra("TalkId",talkid);
        confirm.putExtra("radiobutton",radiobutton);
        confirm.putExtra("datepicker",datepicker);
        confirm.putExtra("Password",password);
        confirm.putExtra("ConfirmPassword",confpassword);
        DatabaseVolley();
        startActivity(confirm);
    }

    public  void DatabaseVolley(){
        //RequestQueue initialized
        mRequestQueue = Volley.newRequestQueue(this);
        //String Request initialized
        mStringRequest = new StringRequest(Request.Method.POST, server_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //display the response on screen

                Toast.makeText(getApplicationContext(), "Response :" + response.toString(), Toast.LENGTH_LONG).show();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i(TAG,"Error :" + error.toString());
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<String, String>();
                params.put("Firstname",firstname);
                params.put("Lastname",lastname);
                params.put("Email",email);
                params.put("TalkId",talkid);
                params.put("radiobutton",radiobutton);
                params.put("datepicker",datepicker);
                params.put("Password",password);
                params.put("ConfirmPassword",confpassword);
                return params;
            }
        };
        mRequestQueue.add(mStringRequest);

    }
}

//datepicker.int("Date" + String.valueOf(day) + "/" + String.valueOf(month + 1) + "/" + String.valueOf(year));