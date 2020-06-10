package com.example.movierating;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegActivity extends AppCompatActivity {

    DatabaseHelper db;
    EditText e1,e2,e3;
    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        db = new DatabaseHelper(this);
        e1=(EditText)findViewById(R.id.name);
        e2=(EditText)findViewById(R.id.email);
        e3=(EditText)findViewById(R.id.pass);
        b1=(Button)findViewById(R.id.register);
        b2=(Button)findViewById(R.id.login);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RegActivity.this,LogActivity.class);
                startActivity(i);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {
                                      String s1 = e1.getText().toString();
                                      String s2 = e2.getText().toString();
                                      String s3 = e3.getText().toString();
                                      if (s1.equals("")||s2.equals("")||s3.equals("")){
                                          Toast.makeText(getApplicationContext(),"Fields are empty",Toast.LENGTH_SHORT).show();
                                      }
                                      else {
                                          Boolean chkemail = db.chkemail(s2);
                                          if(chkemail==true){
                                              Boolean insert = db.insert(s2,s3);
                                              if(insert==true){
                                                  Toast.makeText(getApplicationContext(),"Registered Successfully",Toast.LENGTH_SHORT).show();
                                              }
                                          }
                                          else {
                                              Toast.makeText(getApplicationContext(),"Email Already exist",Toast.LENGTH_SHORT).show();
                                          }
                                      }
                                  }
                              }
        );
    }
}
