package com.example.dsm_t1_mr171621_gl202882;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dsm_t1_mr171621_gl202882.model.User;
import com.example.dsm_t1_mr171621_gl202882.model.db.DBHelper;

public class Register extends AppCompatActivity {

    Button btnRegister, btnLogin;
    EditText name, email, password;

    DBHelper dbHelper;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        user = new User();

        name = (EditText) findViewById(R.id.nameEditText);
        email = (EditText) findViewById(R.id.emailEditText);
        password = (EditText) findViewById(R.id.passwordEditText);

        btnLogin = (Button) findViewById(R.id.login);
        btnRegister = (Button) findViewById(R.id.register);

        btnRegister.setOnClickListener(view -> {
            String n, e, p;
            n = name.getText().toString();
            e = email.getText().toString();
            p = password.getText().toString();

//            Toast.makeText(this, "Toast " + n + e + p, Toast.LENGTH_LONG).show();

//            if (!dbHelper.checkUser(email.getText().toString().trim())) {
                user.setName(n.trim());
                user.setEmail(e.trim());
                user.setPassword(p.trim());
                dbHelper.addUser(user);
                Toast.makeText(this, "Se creo el usuario", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
//            } else {
//                Toast.makeText(this, "El usuario ya existe", Toast.LENGTH_LONG).show();
//            }
        });

        btnLogin.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), Login.class);
            startActivity(intent);
        });
    }
}