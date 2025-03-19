package com.example.appcal;

        import androidx.appcompat.app.AppCompatActivity;
        import androidx.core.app.NotificationCompat;
        import android.app.NotificationManager;
        import android.content.Context;
        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.Toast;


public class AdminActivity extends AppCompatActivity {

    private Button buttonUpdateNotification, buttonScheduleNotification, buttonManageTemplates;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        // Initialize buttons
        buttonUpdateNotification = findViewById(R.id.buttonUpdateNotification);
        buttonScheduleNotification = findViewById(R.id.buttonScheduleNotification);
        buttonManageTemplates = findViewById(R.id.buttonManageTemplates);

        // Set click listeners for buttons
        buttonUpdateNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle click on Send Notification button
                startActivity(new Intent(AdminActivity.this, UpdateNotifications.class));
            }
        });

        buttonScheduleNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle click on Schedule Notification button
                startActivity(new Intent(AdminActivity.this, ScheduleNotifications.class));
            }
        });

        buttonManageTemplates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle click on Manage Templates button
                startActivity(new Intent(AdminActivity.this, ManageTemplates.class));
            }
        });
    }


}