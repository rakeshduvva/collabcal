package com.example.appcal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;



public class Admin_User extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_user);
    }

    public void onUserButtonClick(View view) {
        // Render user login
        Intent intent = new Intent(Admin_User.this, UserLoginActivity.class);
        startActivity(intent);
    }

    public void onAdminButtonClick(View view) {
        // Render admin login
        Intent intent = new Intent(Admin_User.this, AdminLoginActivity.class);
        startActivity(intent);
    }
}
















