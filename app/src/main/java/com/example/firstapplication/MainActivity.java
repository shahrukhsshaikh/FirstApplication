package com.example.firstapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;

public class MainActivity extends AppCompatActivity {

    LinearLayoutCompat linearLayoutCompat;
    EditText usernameEditText;
    EditText passwordEditText;
    Button btnLogin;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        linearLayoutCompat = new LinearLayoutCompat(this);
        linearLayoutCompat.setPadding(10,10,10,10);
        linearLayoutCompat.setOrientation(LinearLayoutCompat.VERTICAL);
        linearLayoutCompat.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);

//        LinearLayout mainContainer = new LinearLayout(this);
//        mainContainer.setOrientation(LinearLayout.VERTICAL);
//        mainContainer.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
//        mainContainer.setPadding(20,20,20,20);

        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        );

        linearLayoutCompat.setLayoutParams(layoutParams);

//        mainContainer.setLayoutParams(layoutParams);

        ViewGroup.LayoutParams layoutParams1 = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );

        usernameEditText = new EditText(this);
        usernameEditText.setPadding(10,10,10,10);
        usernameEditText.setHint("Enter Username");
        usernameEditText.setBackgroundColor(R.color.black);
        usernameEditText.setTextColor(R.color.white);
        usernameEditText.setLayoutParams(layoutParams1);

        linearLayoutCompat.addView(usernameEditText);
//        mainContainer.addView(usernameTextView);

        passwordEditText = new EditText(this);
        passwordEditText.setHint("Enter Password");
        passwordEditText.setPadding(10,10,10,10);
        passwordEditText.setBackgroundColor(R.color.black);
        passwordEditText.setTextColor(R.color.white);
        passwordEditText.setLayoutParams(layoutParams1);
//        passwordTextView.setBackgroundColor(R.color.);

        linearLayoutCompat.addView(passwordEditText);
//        mainContainer.addView(passwordTextView);

        btnLogin = new Button(this);
        btnLogin.setText("Login");
        btnLogin.setPadding(10,10,10,10);
        btnLogin.setLayoutParams(layoutParams1);
        btnLogin.setTextSize(30.0F);

        linearLayoutCompat.addView(btnLogin);
//        mainContainer.addView(btnLogin);

        btnLogin.setOnClickListener(new BtnLoginClickListener());

//        setContentView(mainContainer);
        setContentView(linearLayoutCompat);
    }

    class BtnLoginClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            if (view == btnLogin){
                if((usernameEditText.getText().toString().equals("bitcode") &&
                        (passwordEditText.getText().toString().equals("bitcode@123")))){
                    Toast.makeText(MainActivity.this,"Login Successful",Toast.LENGTH_LONG).show();
                    Log.e("tag", "Success");
                } else {
                    Toast.makeText(MainActivity.this, "Login Falied", Toast.LENGTH_SHORT).show();
                    Log.e("tag", "Failure");
                }
            }
        }
    }
}