package br.ufmg.coltec.e07_rest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import models.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import users.GitConfig;
import users.UsersService;

public class MainActivity extends AppCompatActivity {

    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSearch = findViewById(R.id.btnSearch);
        EditText search = findViewById(R.id.editText);
        UsersService service = new GitConfig().getUsersService();


        btnSearch.setOnClickListener(view -> {
            Call<User> userCall = service.getUser(search.getText().toString());

            userCall.enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    user = response.body();
                    Toast.makeText(MainActivity.this,"Requisição feita com sucesso!", Toast.LENGTH_SHORT).show();
                    Log.d("USER: ", user.toString());
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    intent.putExtra("name", user.getName());
                    intent.putExtra("login", user.getLogin());
                    intent.putExtra("location", user.getLocation());
                    intent.putExtra("repositories", user.getPublicRepositories().toString());
                    intent.putExtra("company", user.getCompany());
                    intent.putExtra("followers", user.getFollowers().toString());
                    intent.putExtra("bio", user.getBio());
                    intent.putExtra("email", user.getEmail());
                    startActivity(intent);
                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {
                    Toast.makeText(MainActivity.this,"Erro durante requisição.", Toast.LENGTH_SHORT).show();
                }
            });
        });
    }
}