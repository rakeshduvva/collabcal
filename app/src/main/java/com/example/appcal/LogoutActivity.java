

package com.example.appcal;

        import android.content.Intent;
        import android.os.Bundle;
        import androidx.appcompat.app.AppCompatActivity;

public class LogoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);

        // Call logout method when this activity is created
        logout();
    }

    // Method to perform logout
    private void logout() {
        // Here, you can perform any logout-related tasks, such as clearing session data, etc.

        // Redirect to SplashScreen after logout
        Intent intent = new Intent(this, Splash_Screen.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

        // Finish all activities in the stack to prevent the user from coming back to them with the back button
        finishAffinity();
    }
}
