package br.ufmg.coltec.e07_rest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ActivityDados extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados);

        Bundle activityBundle = this.getIntent().getExtras();
        String name = activityBundle.getString("name");
        String login = activityBundle.getString("login");
        String company = activityBundle.getString("company");
        String blog = activityBundle.getString("blog");
        String location = activityBundle.getString("location");
        String email = activityBundle.getString("email");
        String bio = activityBundle.getString("bio");
        int public_repos = activityBundle.getInt("public_repos");
        int followers = activityBundle.getInt("followers");

        TextView txtNome = findViewById(R.id.txt_nome);
        TextView txtLogin = findViewById(R.id.txt_login);
        TextView txtLocal = findViewById(R.id.txt_local);
        TextView txtEmpresa = findViewById(R.id.txt_empresa);
        TextView txtBlog = findViewById(R.id.txt_blog);
        TextView txtEmail = findViewById(R.id.txt_email);
        TextView txtBio = findViewById(R.id.txt_bio);
        TextView txtRepositorios = findViewById(R.id.txt_repositorios);
        TextView txtsSeguidores = findViewById(R.id.txt_seguidores);

        txtNome.setText(name);
        txtLogin.setText(login);
        txtLocal.setText(location);
        txtEmpresa.setText(company);
        txtBlog.setText(blog);
        txtEmail.setText(email);
        txtBio.setText(bio);
        txtRepositorios.setText("" + public_repos);
        txtsSeguidores.setText(""+ followers);



    }
}