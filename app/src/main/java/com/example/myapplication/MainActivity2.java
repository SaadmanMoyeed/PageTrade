package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.ktx.Firebase;

public class MainActivity2 extends AppCompatActivity {
    FirebaseAuth auth;
    TextView textView;
    FirebaseUser user;
    Button signout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        auth = FirebaseAuth.getInstance();
        textView = findViewById(R.id.seller_home);
        signout = findViewById(R.id.signout);
        user = auth.getCurrentUser();
        if (user == null) {
            Intent intent = new Intent(getApplicationContext(), Seller_login.class);
            startActivity(intent);
            finish();
        }
        else{
            textView.setText(user.getEmail());
        }
        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(), Seller_login.class);
                startActivity(intent);
                finish();
            }
        });
        }

    }
