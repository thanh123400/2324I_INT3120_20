package com.example.shared_preferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edittext_name, edittext_email;
    Button button_save;
    SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_NAME = "name";
    private static final String KEY_EMAIL = "email";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edittext_name = findViewById(R.id.edittext_name);
        edittext_email = findViewById(R.id.edittext_email);
        button_save = findViewById(R.id.button_save);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);


        String name = sharedPreferences.getString(KEY_NAME, null);
        if (name != null) {
            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(intent);
        }

//        String email = sharedPreferences.getString(KEY_EMAIL, null);


        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(KEY_NAME, edittext_name.getText().toString());
                editor.putString(KEY_EMAIL, edittext_email.getText().toString());
                editor.apply();
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);

                Toast.makeText(MainActivity.this, "login succes", Toast.LENGTH_SHORT).show();

            }
        });

    }
}