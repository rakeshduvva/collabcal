package com.example.appcal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateNotifications extends AppCompatActivity {

    private EditText editTextTitle, editTextDate, editTextTime, editTextDescription;
    private Button buttonSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_notifications);


        // Initialize EditText fields and Button
        editTextTitle = findViewById(R.id.editTextTitle);
        editTextDate = findViewById(R.id.editTextDate);
        editTextTime = findViewById(R.id.editTextTime);
        editTextDescription = findViewById(R.id.editTextDescription);
        buttonSave = findViewById(R.id.buttonSave);

        // Set OnClickListener for the Save button
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the text from EditText fields
                String title = editTextTitle.getText().toString();
                String date = editTextDate.getText().toString();
                String time = editTextTime.getText().toString();
                String description = editTextDescription.getText().toString();

                // Check if any of the fields is empty
                if (title.isEmpty() || date.isEmpty() || time.isEmpty() || description.isEmpty()) {
                    Toast.makeText(UpdateNotifications.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                } else {
                    // Perform actions to save the event (e.g., store in database)
                    // For now, just show a toast message
                    Toast.makeText(UpdateNotifications.this, "Event saved", Toast.LENGTH_SHORT).show();

                    // Clear EditText fields after saving the event
                    clearFields();
                }
            }
        });
    }

    // Method to clear EditText fields
    private void clearFields() {
        editTextTitle.setText("");
        editTextDate.setText("");
        editTextTime.setText("");
        editTextDescription.setText("");
    }
}
