package br.ufmg.coltec.tp.e07_rest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URL;

import models.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ws.GithubConfig;
import ws.UserService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText login = findViewById(R.id.txt_search_user);
        Button button = findViewById(R.id.btn_search_user);
        button.setOnClickListener(v -> {
            GithubConfig githubConfig = new GithubConfig();
            UserService service = githubConfig.getUserService();
            Call<User> userCall = service.getUser(login.getText().toString());

            userCall.enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    User user = response.body();
                    if(user != null){
                        Intent intent = new Intent(MainActivity.this, UserActivity.class);
                        intent.putExtra("user", user);
                        startActivity(intent);
                    }else{
                        Toast.makeText(MainActivity.this, "Erro ao buscar usuário.", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {
                    Toast.makeText(MainActivity.this, "Erro ao buscar usuário.", Toast.LENGTH_SHORT).show();
                }
            });
        });
    }
}