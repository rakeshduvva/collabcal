package com.example.appcal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import android.content.Intent;
import android.widget.ImageView;



public class CalendarActivity extends AppCompatActivity {

    private CalendarView calendarView;
    private HashMap<Date, String> events;
    private TextView userTextView;

    private  TextView welcomeTextView;
    private ImageView settingsIcon;
    private ImageView addEventsIcon;
    private ImageView remindersIcon;

    private ImageView exitIcon;
    private ImageView listIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        // Initialize views
        calendarView = findViewById(R.id.calendar_view);
        userTextView = findViewById(R.id.main_user_text);
        welcomeTextView=findViewById(R.id.main_welcome_text);
        settingsIcon = findViewById(R.id.settings_icon);
        addEventsIcon = findViewById(R.id.add_events_icon);
        remindersIcon = findViewById(R.id.reminders_icon);
        exitIcon=findViewById(R.id.logout_icon);
        listIcon=findViewById(R.id.list_icon);

        // Set click listeners for icons



        settingsIcon.setOnClickListener(v -> startActivity(new Intent(CalendarActivity.this, SettingsActivity.class)));


        addEventsIcon.setOnClickListener(v -> startActivity(new Intent(CalendarActivity.this, AddEventsActivity.class)));


        remindersIcon.setOnClickListener(v -> startActivity(new Intent(CalendarActivity.this, RemindersActivity.class)));


        exitIcon.setOnClickListener(v -> startActivity(new Intent(CalendarActivity.this,LogoutActivity.class)));

        listIcon.setOnClickListener(v -> startActivity(new Intent(CalendarActivity.this, ListEvents.class)));

        // Read events from CSV
        readEventsFromCSV(R.raw.festivals2024);
        readEventsFromCSV(R.raw.academiccalendar1);
        readEventsFromCSV(R.raw.academiccalendar3);
        readEventsFromCSV(R.raw.academiccalendar2);
        readEventsFromCSV(R.raw.academiccalendar4);

        // Display username
        displayUsername();

        // Set listener for calendar date changes
        calendarView.setOnDateChangeListener((view, year, month, dayOfMonth) -> onSelectedDayChange(view, year, month, dayOfMonth));
        }




    // Method to read events from CSV file
    private void readEventsFromCSV(int resourceId) {

        if (events==null) {
            // Initialize events HashMap
            events = new HashMap<>();
        }


        InputStream inputStream = getResources().openRawResource(resourceId);// Assuming the CSV file is stored in the "raw" folder
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));



        String line;
        try {
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    // Parse date from string
                    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                    Date date = sdf.parse(parts[0].trim());
                    events.put(date, parts[1].trim()); // Assuming date is the first column and event name is the third column
                }
            }
            bufferedReader.close();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    private Date setToMidnight(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    // Method to display username on the dashboard
    private void displayUsername() {
        // Get the username from the credentials HashMap
        String username = getIntent().getStringExtra("username");
        if (username != null && !username.isEmpty()) {
            userTextView.setText(username);
        }
    }

    private void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {

        // Create a Calendar instance and set it to the selected date
        Calendar selectedDate = Calendar.getInstance();
        selectedDate.set(year, month, dayOfMonth);
        selectedDate.set(Calendar.HOUR_OF_DAY, 0);
        selectedDate.set(Calendar.MINUTE, 0);
        selectedDate.set(Calendar.SECOND, 0);
        selectedDate.set(Calendar.MILLISECOND, 0);

        // Check if the selected date has a event
        if (events.containsKey(selectedDate.getTime())) {
            // If there's a event, display a toast with its name
            String event = events.get(selectedDate.getTime());
            Toast.makeText(CalendarActivity.this, "Event: " + event, Toast.LENGTH_SHORT).show();
        } else {
            // If there's no event, display a message
            Toast.makeText(CalendarActivity.this, "No event on this date", Toast.LENGTH_SHORT).show();
        }
    }
}






