package com.example.melodee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private Button submitBtn;
    private EditText usernameTxt, passwordTxt;
    private TextView errorMsg;
    static User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initialize();

        this.submitBtn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP){
                    submitBtn.setBackgroundColor(Color.parseColor("#FF8700"));
                }
                else {
                    submitBtn.setBackgroundColor(Color.parseColor("#00CCB2"));
                }
                return false;
            }
        });

        this.submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                validateInput();
            }
        });
    }

    private void validateInput() {
        String name, password;
        name = this.usernameTxt.getText().toString();
        password = this.passwordTxt.getText().toString();

        //if username is empty
        if(name.isEmpty()){
            this.errorMsg.setText("Username must be filled");
        }
        //else if password is empty
        else if(password.isEmpty()){
            this.errorMsg.setText("Password must be filled");
        }
        //else if password is not alphanumeric
        else if(password.matches("[a-zA-Z0-9]+") == false){
            this.errorMsg.setText("Password must be alphanumeric");
        }
        else{
            this.errorMsg.setText("");
//            user.setUsername(usernameTxt.getText().toString());
            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
            intent.putExtra("USERNAME", usernameTxt.getText().toString());
            intent.putExtra("PAGENAME", "Home");
            startActivity(intent);
        }

    }

    private void initialize() {
        this.submitBtn = findViewById(R.id.submitBtn);
        this.usernameTxt = findViewById(R.id.usernameInput);
        this.passwordTxt = findViewById(R.id.passwordInput);
        this.errorMsg = findViewById(R.id.errorMsg);
    }
}