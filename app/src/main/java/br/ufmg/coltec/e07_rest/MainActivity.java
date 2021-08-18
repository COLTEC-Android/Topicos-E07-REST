package br.ufmg.coltec.e07_rest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText userName = findViewById(R.id.txt_search_user);
        Button button = findViewById(R.id.btn_search_user);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, UserActivity.class);
            Bundle args = new Bundle();
            args.putCharSequence("name", userName.getText().toString());
            intent.putExtras(args);
            startActivity(intent);
        });
    }
}