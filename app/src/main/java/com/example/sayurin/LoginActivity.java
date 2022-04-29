package com.example.sayurin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sayurin.Model.Session;

public class LoginActivity extends AppCompatActivity {
    public static final String USERNAME_KEY = "username";

    public EditText usernameInput, passwordInput, confirmInput;
    public String usernameValue, passValue, confirmValue;
    private Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameInput = findViewById(R.id.username);
        passwordInput = findViewById(R.id.pass);
        confirmInput = findViewById(R.id.confirm);

        session = new Session(this);
    }

    public void handleLogin (View view) {
        usernameValue = usernameInput.getText().toString();
        passValue = passwordInput.getText().toString();
        confirmValue = confirmInput.getText().toString();

        if (usernameValue.equals("")) {
            usernameInput.setError("Isi data terlebih dahulu");
        } else if (passValue.equals("")) {
            passwordInput.setError("Isi data terlebih dahulu");
        } else if (confirmValue.equals("")) {
            confirmInput.setError("Isi confirm password");
        } else if (!passValue.equals(confirmValue)) {
            confirmInput.setError("Password harus sama");
        } else {
            boolean status = session.validate(usernameValue, passValue, confirmValue);
            if (status) {
                //
                if (session.isKeepUsername()) {
                    session.setUsername(usernameValue);
                }
                Intent intent = new Intent(this, MainActivity.class);
                intent.putExtra(USERNAME_KEY,usernameValue);
                startActivity(intent);
                finish();

            } else {
                Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void handleReset(View view) {
        usernameInput.setText("");
        passwordInput.setText("");
        confirmInput.setText("");
    }
}
