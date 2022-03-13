package com.example.dsm_t1_mr171621_gl202882;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.example.dsm_t1_mr171621_gl202882.model.db.DBHelper;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class Login extends AppCompatActivity {

    private final AppCompatActivity activity = Login.this;

    private Button btnLogin;
    private Button btnRegister;

    private TextInputLayout emailLayout;
    private TextInputLayout passwordLayout;

    private TextInputEditText emailEditText;
    private TextInputEditText passwordEditText;

    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initViews();
        initListeners();
        initInstances();

        btnLogin.setOnClickListener(view -> {
            if (dbHelper.login(emailEditText.getText().toString().trim(), passwordEditText.getText().toString().trim())) {
                Toast.makeText(this, "¡Bienvenido!", Toast.LENGTH_LONG).show();
                emailEditText.getText().clear();
                passwordEditText.getText().clear();
                Intent intentMain = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intentMain);
            } else {
                Toast.makeText(this, "Datos incorrectos", Toast.LENGTH_LONG).show();
            }
        });

        btnRegister.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), Register.class);
            startActivity(intent);
        });
    }

    private void initViews() {
        emailLayout = (TextInputLayout)findViewById(R.id.emailLayout);
        passwordLayout = (TextInputLayout) findViewById(R.id.passwordLayout);

        emailEditText = (TextInputEditText) findViewById(R.id.emailEditText);
        passwordEditText = (TextInputEditText) findViewById(R.id.passwordEditText);
    }

    private void initListeners() {
        btnLogin = (Button) findViewById(R.id.login);
        btnRegister = (Button)findViewById(R.id.register);
    }

    private void initInstances() {
        dbHelper = new DBHelper(activity);
    }
}