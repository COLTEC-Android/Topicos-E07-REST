package br.ufmg.coltec.e07_rest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import models.Usuario;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ws.UsuarioService;
import ws.RetrofitConfig;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText txtUser = this.findViewById(R.id.txt_user);
        Button btnSearch = this.findViewById(R.id.btn_seach);
        RetrofitConfig apiConfig = new RetrofitConfig();

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = txtUser.getText().toString();

                RetrofitConfig retrofitConfig = new RetrofitConfig();
                UsuarioService service = retrofitConfig.getUsuarioService();
                Call<Usuario> usuarioCall = service.getUsuario(user);

                usuarioCall.enqueue(new Callback<Usuario>() {
                    @Override
                    public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                        Toast.makeText(MainActivity.this, R.string.string_txt_toast_response, Toast.LENGTH_LONG).show();

                        Usuario usuario = response.body();
                        assert usuario != null;
                        Log.d("ON_RESPONSE", usuario.toString());

                        Intent intent = new Intent(MainActivity.this, UsuarioActivity.class);
                        intent.putExtra("user", usuario);
                        startActivity(intent);

                    }

                    @Override
                    public void onFailure(Call<Usuario> call, Throwable t) {
                        Toast.makeText(MainActivity.this, R.string.string_txt_toast_failure, Toast.LENGTH_LONG).show();
                        t.printStackTrace();
                    }
                });
            }
        });

    }
}