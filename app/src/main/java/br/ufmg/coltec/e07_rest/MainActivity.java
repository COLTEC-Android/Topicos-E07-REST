package br.ufmg.coltec.e07_rest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buscar = findViewById(R.id.btn_buscar);
        EditText login = findViewById(R.id.lbl_login);


        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GitHubService service = new RetrofitConfig().getGitHubService();
                Call<User> userCall = service.getUser(login.getText().toString());

                userCall.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        User user = response.body();

                        Intent intent = new Intent(MainActivity.this, ActivityDados.class);
                        Bundle args = new Bundle();
                        args.putCharSequence("name", user.getName());
                        args.putCharSequence("login", user.getLogin());
                        args.putCharSequence("company", user.getCompany());
                        args.putCharSequence("blog", user.getBlog());
                        args.putCharSequence("location", user.getLocation());
                        args.putCharSequence("email", user.getEmail());
                        args.putCharSequence("bio", user.getBio());
                        args.putInt("public_repos", user.getPublic_repos());
                        args.putInt("followers", user.getFollowers());

                        intent.putExtras(args);

                        startActivity(intent);

                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "Erro ao buscar usuário", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });


    }
}