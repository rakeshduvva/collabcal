package com.example.appcal;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

public class UserLoginActivity extends AppCompatActivity {

    private EditText editTextUserName;
    private EditText editTextPassword;
    private Button buttonLogin;
    private TextView textViewNewUser;
    private HashMap<String, String> credentials;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        // Initialize views
        editTextUserName = findViewById(R.id.editTextUser_Name);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.button);
        textViewNewUser = findViewById(R.id.textViewNewUser);

        // Read usernames and passwords from CSV file
        credentials = readCredentialsFromCSV();

        // Set click listener for the login button
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get username and password from EditText fields
                String username = editTextUserName.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();

                // Check if username and password match the credentials from the CSV file
                if (credentials.containsKey(username) && credentials.get(username).equals(password)) {
                    // If credentials are correct, show a toast message and navigate to the user dashboard
                    Toast.makeText(UserLoginActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                    // TODO: Add code to navigate to the user dashboard activity
                    Intent intent = new Intent(UserLoginActivity.this, CalendarActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    // If credentials are incorrect, show a toast message
                    Toast.makeText(UserLoginActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    // Method to read usernames and passwords from CSV file and return as HashMap
    private HashMap<String, String> readCredentialsFromCSV() {
        HashMap<String, String> credentials = new HashMap<>();
        InputStream inputStream = getResources().openRawResource(R.raw.userpasscalendarapp); // Assuming the CSV file is stored in the "raw" folder
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        try {
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(",");
                credentials.put(parts[0], parts[1]);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return credentials;
    }
}













