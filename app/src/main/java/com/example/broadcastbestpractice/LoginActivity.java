package com.example.broadcastbestpractice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends BaseActivity{
    private EditText usernameText;
    private EditText passwordText;
    private Button loginBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginBtn=(Button)findViewById(R.id.login_btn);
        usernameText=(EditText) findViewById(R.id.username_text);
        passwordText=(EditText) findViewById(R.id.password_text);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=usernameText.getText().toString();
                String password=passwordText.getText().toString();
                if(username.equals("admin")&& password.equals("123456")){
                    Toast.makeText(LoginActivity.this,"login success",Toast.LENGTH_SHORT);
                    Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                else{
                    Toast.makeText(LoginActivity.this,"login failed! check your info correct",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
