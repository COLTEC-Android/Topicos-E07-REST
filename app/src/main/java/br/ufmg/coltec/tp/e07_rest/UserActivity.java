package br.ufmg.coltec.tp.e07_rest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.InputStream;
import java.net.URL;
import models.User;


public class UserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        Intent intent = getIntent();
        User user = (User) intent.getSerializableExtra("user");

        ProgressBar progressBar = findViewById(R.id.ProgressBar);
        ImageView avatar = findViewById(R.id.img_avatar);
        TextView nome = findViewById(R.id.txt_nome);
        TextView login = findViewById(R.id.txt_login);
        TextView empresa = findViewById(R.id.txt_empresa);
        TextView blog = findViewById(R.id.txt_blog);
        TextView local = findViewById(R.id.txt_local);
        TextView email = findViewById(R.id.txt_email);
        TextView biografia = findViewById(R.id.txt_biografia);
        TextView numeroRepositorios = findViewById(R.id.txt_numero_repositorios);
        TextView numeroSeguidores = findViewById(R.id.txt_numero_seguidores);

        nome.setText(user.getNome());
        login.setText(user.getLogin());
        empresa.setText(user.getEmpresa());
        blog.setText(user.getBlog());
        local.setText(user.getLocal());
        email.setText(user.getEmail());
        biografia.setText(user.getBiografia());
        numeroRepositorios.setText(user.getNumeroRepositorios());
        numeroSeguidores.setText(user.getNumeroSeguidores());



        // Baixa a Url
        new DownloadImageTask(avatar, progressBar).execute(user.getAvatarUrl());
    }
}

/*
AsyncTask foi marcado como deprecated no Android 11 (API 30). Como geralmente usamos a 23 e
é apenas um exercício, não vi problema em usar.
*/
class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
    ImageView avatar;
    ProgressBar progressBar;

    public DownloadImageTask(ImageView avatar, ProgressBar progressBar) {
        this.avatar = avatar;
        this.progressBar = progressBar;
    }

    protected void onPreExecute() {
        progressBar.setVisibility(View.VISIBLE);
    }

    protected Bitmap doInBackground(String... urls) {
        String url = urls[0];
        Bitmap bitmap = null;
        try {
            InputStream in = new java.net.URL(url).openStream();
            bitmap = BitmapFactory.decodeStream(in);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    protected void onPostExecute(Bitmap result) {
        progressBar.setVisibility(View.GONE);
        avatar.setImageBitmap(result);
    }
}