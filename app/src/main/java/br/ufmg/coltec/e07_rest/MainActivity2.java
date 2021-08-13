package br.ufmg.coltec.e07_rest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import models.User;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();

        TextView name = findViewById(R.id.name);
        TextView login = findViewById(R.id.username);
                TextView location = findViewById(R.id.location);
        TextView repositories = findViewById(R.id.public_repositories);
                TextView company = findViewById(R.id.company);
        TextView followers = findViewById(R.id.followers);
                TextView bio = findViewById(R.id.bio);
        TextView email = findViewById(R.id.email);

        name.setText(intent.getStringExtra("name"));
        login.setText(intent.getStringExtra("login"));
        location.setText(intent.getStringExtra("location"));
        repositories.setText(intent.getStringExtra("repositories"));
        company.setText(intent.getStringExtra("company"));
        followers.setText(intent.getStringExtra("followers"));
        bio.setText(intent.getStringExtra("bio"));
        email.setText(intent.getStringExtra("email"));
    }
}