package com.example.dsm_t1_mr171621_gl202882;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dsm_t1_mr171621_gl202882.model.db.DBHelper;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class Login extends AppCompatActivity {

    Button btnLogin, btnRegister;
//    TextInputLayout emailLayout, passwordLayout;
//    TextInputEditText emailEditText, passwordEditText;

    EditText emailEditText, passwordEditText;

    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

//        emailLayout = (TextInputLayout)findViewById(R.id.emailLayout);
//        passwordLayout = (TextInputLayout) findViewById(R.id.passwordLayout);

//        emailEditText = (TextInputEditText) findViewById(R.id.emailEditText);
//        passwordEditText = (TextInputEditText) findViewById(R.id.passwordEditText);

        emailEditText = (EditText) findViewById(R.id.emailEditText);
        passwordEditText = (EditText) findViewById(R.id.passwordEditText);

        btnLogin = (Button)findViewById(R.id.login);
        btnRegister = (Button)findViewById(R.id.register);

        btnLogin.setOnClickListener(view -> {
            String e = emailEditText.getText().toString();
            String p = passwordEditText.getText().toString();

            String m = "Datos " + e + " " + p;

            Toast.makeText(this, m, Toast.LENGTH_LONG).show();

            if (dbHelper.login(e, p)) {
                Toast.makeText(this, "Datos correctos", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Datos incorrectos", Toast.LENGTH_LONG).show();
            }
        });

        btnRegister.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), Register.class);
            startActivity(intent);
        });
    }
}