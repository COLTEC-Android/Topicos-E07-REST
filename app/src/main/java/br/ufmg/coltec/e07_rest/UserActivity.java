package br.ufmg.coltec.e07_rest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class UserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        Intent intent = getIntent();
        User user = (User) intent.getSerializableExtra("user");

        TextView txtNome = findViewById(R.id.userNome);
        TextView txtBio = findViewById(R.id.userBio);
        TextView txtLogin = findViewById(R.id.userLogin);
        TextView txtEmail = findViewById(R.id.userEmail);
        TextView txtSeguidores = findViewById(R.id.userFollowers);
        TextView txtLocal = findViewById(R.id.userLocal);
        TextView txtBlog = findViewById(R.id.userBlog);
        TextView txtRepositorios = findViewById(R.id.userRep);
        TextView txtEmpresa = findViewById(R.id.userCompany);

        txtNome.setText(user.getName());
        txtBio.setText(user.getBio());
        txtLogin.setText(user.getLogin());
        txtEmail.setText(user.getEmail());
        txtSeguidores.setText(user.getFollowers() + "");
        txtLocal.setText(user.getLocation());
        txtBlog.setText(user.getBlog());
        txtRepositorios.setText(user.getPublic_repos() + "");
        txtEmpresa.setText(user.getCompany());
    }
}