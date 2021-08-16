package br.ufmg.coltec.e07_rest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import models.Usuario;

public class UsuarioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);

        Usuario usuario = (Usuario) getIntent().getSerializableExtra("user");

        TextView txtName = findViewById(R.id.txt_name);
        TextView txtLogin = findViewById(R.id.txt_login);
        TextView txtCompany = findViewById(R.id.txt_company);
        TextView txtBlog = findViewById(R.id.txt_blog);
        TextView txtLocation = findViewById(R.id.txt_location);
        TextView txtEmail = findViewById(R.id.txt_email);
        TextView txtBio = findViewById(R.id.txt_bio);
        TextView txtPublicRepos = findViewById(R.id.txt_public_repos);
        TextView txtFollowers = findViewById(R.id.txt_followers);

        txtName.setText(usuario.getName());
        txtLogin.setText(usuario.getLogin());
        txtCompany.setText(usuario.getCompany());
        txtBlog.setText(usuario.getBlog());
        txtLocation.setText(usuario.getLocation());
        txtEmail.setText(usuario.getEmail());
        txtBio.setText(usuario.getBio());
        txtPublicRepos.setText(usuario.getPublic_repos());
        txtFollowers.setText(usuario.getFollowers());

    }
}