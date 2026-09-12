package com.example.loginactivity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // 1. Declare variables
    EditText etUsername, etPassword;
    Button btnLogin;

    // Hardcoded values (As requested by the assignment)
    String correctUsername = "admin";
    String correctPassword = "1234";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 2. Connect Java variables to XML IDs
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);

        // 3. Add ClickListener to the button
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Get the text from inputs
                String userInput = etUsername.getText().toString().trim();
                String passInput = etPassword.getText().toString().trim();

                // 4. Validate if fields are empty
                if (userInput.isEmpty() || passInput.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                // 5. Check against hardcoded values
                if (userInput.equals(correctUsername) && passInput.equals(correctPassword)) {
                    // Success
                    Toast.makeText(MainActivity.this, "Welcome, " + userInput + "!", Toast.LENGTH_LONG).show();

                    // Hide the form as per instructions
                    etUsername.setVisibility(View.INVISIBLE);
                    etPassword.setVisibility(View.INVISIBLE);
                    btnLogin.setVisibility(View.INVISIBLE);

                } else {
                    // Error
                    Toast.makeText(MainActivity.this, "Error: Invalid Credentials", Toast.LENGTH_SHORT).show();

                    // Clear fields
                    etUsername.setText("");
                    etPassword.setText("");
                    etUsername.requestFocus();
                }
            }
        });
    }
}