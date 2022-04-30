package com.example.lawmanagementsystem;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.nio.charset.StandardCharsets;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Login extends AppCompatActivity {
    EditText username,password;
    Button btnsignin;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username =(EditText) findViewById(R.id.username1);
        password = (EditText) findViewById(R.id.password1);
        btnsignin = (Button) findViewById(R.id.btnsignin26);
        DB = new DBHelper(this);
        btnsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                if(user.equals(" ")|| pass.equals(""))
                    Toast.makeText(Login.this, "Please Enter All the fields", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuserpass = DB.checkusernamepassword(user,pass);
                    if(checkuserpass==true){
                        Toast.makeText(Login.this, "Sign in Successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),bottomnavigation.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(Login.this, "Invalid Crendentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    }
