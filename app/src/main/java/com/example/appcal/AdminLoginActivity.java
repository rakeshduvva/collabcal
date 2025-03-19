package com.example.appcal;


        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;

public class AdminLoginActivity extends AppCompatActivity {

    private EditText editTextUserName;
    private EditText editTextPassword;
    private Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        // Initialize views
        editTextUserName = findViewById(R.id.editTextUser_Name);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.button);

        // Set click listener for the login button
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get username and password from EditText fields
                String username = editTextUserName.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();

                // Check if username and password match the admin credentials
                if (username.equals("admin@2024") && password.equals("admin@ethi")) {
                    // If credentials are correct, show a toast message and navigate to the admin dashboard
                    Toast.makeText(AdminLoginActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                    // TODO: Add code to navigate to the admin dashboard activity
                    Intent intent = new Intent(AdminLoginActivity.this, AdminActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    // If credentials are incorrect, show a toast message
                    Toast.makeText(AdminLoginActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
