package com.example.homework_m2_lesson6;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView loginText = findViewById(R.id.login_text);
        LinearLayout firstLinear = findViewById(R.id.first_linear);
        LinearLayout lastLinear = findViewById(R.id.last_linear);
        Button voityBtn = findViewById(R.id.voity_btn);
        Button touchItBtn = findViewById(R.id.touch_it_btn);
        EditText login = findViewById(R.id.login);
        EditText pass = findViewById(R.id.pass);

        login.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (login.getText().toString().equals("") & pass.getText().toString().equals("")) {
                    voityBtn.setEnabled(false);
                    voityBtn.setBackground(getDrawable(R.drawable.before_changed));

                } else {
                    voityBtn.setEnabled(true);
                    voityBtn.setBackground(getDrawable(R.drawable.btn_orange));
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        pass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (pass.getText().toString().equals("") & login.getText().toString().equals("")) {
                    voityBtn.setEnabled(false);
                    voityBtn.setBackground(getDrawable(R.drawable.before_changed));

                } else {
                    voityBtn.setEnabled(true);
                    voityBtn.setBackground(getDrawable(R.drawable.btn_orange));
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        voityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ("admin".equals(login.getText().toString()) && "admin".equals(pass.getText().toString())) {
                    firstLinear.setVisibility(View.GONE);
                    lastLinear.setVisibility(View.GONE);
                    loginText.setVisibility(View.INVISIBLE);
                    Toast.makeText(MainActivity.this, "Вы успешно зарегистрировались", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText( MainActivity.this, "Неправильный логин и пароль", Toast.LENGTH_SHORT).show();
                }
            }
        });

        touchItBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "(логин: admin; пароль: admin)", Toast.LENGTH_LONG).show();
            }
        });


    }
}