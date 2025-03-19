package com.example.appcal;



import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        sharedPreferences = getSharedPreferences("settings", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        // Theme Selection
        RadioButton lightThemeRadioButton = findViewById(R.id.lightThemeRadioButton);
        RadioButton darkThemeRadioButton = findViewById(R.id.darkThemeRadioButton);

        String selectedTheme = sharedPreferences.getString("theme", "light");
        if (selectedTheme.equals("light")) {
            lightThemeRadioButton.setChecked(true);
        } else {
            darkThemeRadioButton.setChecked(true);
        }

        RadioGroup themeSelectionRadioGroup = findViewById(R.id.themeSelectionRadioGroup);
        themeSelectionRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = findViewById(checkedId);
                String selectedTheme = radioButton.getText().toString().toLowerCase();
                editor.putString("theme", selectedTheme);
                editor.apply();
                Toast.makeText(SettingsActivity.this, "Theme set to " + selectedTheme, Toast.LENGTH_SHORT).show();
            }
        });

        // Notification Settings
        RadioGroup notificationSettingsRadioGroup = findViewById(R.id.notificationSettingsRadioGroup);
        notificationSettingsRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = findViewById(checkedId);
                String selectedNotificationOption = radioButton.getText().toString();
                editor.putString("notification_option", selectedNotificationOption);
                editor.apply();
                Toast.makeText(SettingsActivity.this, "Notification option set to " + selectedNotificationOption, Toast.LENGTH_SHORT).show();
            }
        });

        // Time Format
        RadioGroup timeFormatRadioGroup = findViewById(R.id.timeFormatRadioGroup);
        timeFormatRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = findViewById(checkedId);
                String selectedTimeFormat = radioButton.getText().toString();
                editor.putString("time_format", selectedTimeFormat);
                editor.apply();
                Toast.makeText(SettingsActivity.this, "Time format set to " + selectedTimeFormat, Toast.LENGTH_SHORT).show();
            }
        });
    }
}

