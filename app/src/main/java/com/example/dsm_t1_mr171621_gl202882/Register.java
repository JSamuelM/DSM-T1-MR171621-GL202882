package com.example.dsm_t1_mr171621_gl202882;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dsm_t1_mr171621_gl202882.model.User;
import com.example.dsm_t1_mr171621_gl202882.model.db.DBHelper;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class Register extends AppCompatActivity {

    private final AppCompatActivity activity = Register.this;

    private Button btnRegister;
    private Button btnLogin;

    private TextInputLayout nameLayout;
    private TextInputLayout emailLayout;
    private TextInputLayout passwordLayout;

    private TextInputEditText nameEditText;
    private TextInputEditText emailEditText;
    private TextInputEditText passwordEditText;

    private EditText name, email, password;

    private DBHelper dbHelper;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initViews();
        initListeners();
        init();

        btnRegister.setOnClickListener(view -> {
            if (!dbHelper.checkUser(emailEditText.getText().toString().trim())) {

                user.setName(nameEditText.getText().toString().trim());
                user.setEmail(emailEditText.getText().toString().trim());
                user.setPassword(passwordEditText.getText().toString().trim());

                dbHelper.addUser(user);

                Toast.makeText(this, "Se creo el usuario", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(this, "Ya existe un usuario con ese correo", Toast.LENGTH_LONG).show();
            }
        });

        btnLogin.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), Login.class);
            startActivity(intent);
        });
    }

    private void initViews() {
        nameLayout = (TextInputLayout)findViewById(R.id.nameLayout);
        emailLayout = (TextInputLayout)findViewById(R.id.emailLayout);
        passwordLayout = (TextInputLayout) findViewById(R.id.passwordLayout);

        nameEditText = (TextInputEditText)findViewById(R.id.nameEditText);
        emailEditText = (TextInputEditText) findViewById(R.id.emailEditText);
        passwordEditText = (TextInputEditText) findViewById(R.id.passwordEditText);
    }

    private void initListeners() {
        btnLogin = (Button) findViewById(R.id.login);
        btnRegister = (Button)findViewById(R.id.register);
    }

    private void init() {
        dbHelper = new DBHelper(activity);
        user = new User();
    }
}