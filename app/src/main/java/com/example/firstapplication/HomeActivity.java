package com.example.firstapplication;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;

public class HomeActivity extends AppCompatActivity{

    Button btnLogin;
    TextView welcomeTextView;
    EditText usernameEditText;
    LinearLayoutCompat mainContainer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mainContainer = new LinearLayoutCompat(this);
        mainContainer.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
        mainContainer.setOrientation(LinearLayoutCompat.VERTICAL);

        welcomeTextView = new TextView(this);
        usernameEditText = new EditText(this);
        btnLogin = new Button(this);

        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        );

        mainContainer.setLayoutParams(layoutParams);

        ViewGroup.LayoutParams layoutParams1 = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );

        welcomeTextView.setLayoutParams(layoutParams1);
        welcomeTextView.setText("Welcome To Bitcode");
        mainContainer.addView(welcomeTextView);

        usernameEditText.setLayoutParams(layoutParams1);
        usernameEditText.setHint("Enter username");
        mainContainer.addView(usernameEditText);

        btnLogin.setLayoutParams(layoutParams1);
        btnLogin.setText("Login");
        mainContainer.addView(btnLogin);

        btnLogin.setOnClickListener(new MyBtnLoginClickListener());
        setContentView(mainContainer);
    }

    class MyBtnLoginClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            if (view == btnLogin){
                welcomeTextView.setText("Welcome " + usernameEditText.getText().toString());
            } else {
                Toast.makeText(HomeActivity.this,"Login Failed", Toast.LENGTH_LONG).show();
            }
        }
    }
}