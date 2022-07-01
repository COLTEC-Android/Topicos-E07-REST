package br.ufmg.coltec.e07_rest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class
MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnProcurar = findViewById(R.id.btnBuscar);
        EditText editText = findViewById(R.id.txtUsuario);

        btnProcurar.setOnClickListener(view -> {
            String usuario = editText.getText().toString();

            RetrofitConfig retrofitConfig = RetrofitConfig.getInstance();
            GitService gitService = retrofitConfig.getGitService();

            Call<User> call = gitService.getUser(usuario);

            call.enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    User user = response.body();
                    if(user == null){
                        Toast.makeText(MainActivity.this, "Usuario Inválido", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Intent intent = new Intent(MainActivity.this, UserActivity.class);
                        intent.putExtra("user", user);
                        startActivity(intent);
                    }
                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {

                }
            });
        });
    }
}