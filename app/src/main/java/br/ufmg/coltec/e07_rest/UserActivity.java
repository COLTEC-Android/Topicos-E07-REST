package br.ufmg.coltec.e07_rest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import ws.GithubConfig;
import ws.UserService;
import models.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        Bundle activityBundle = this.getIntent().getExtras();
        String name = activityBundle.getString("name");

        GithubConfig githubConfig = new GithubConfig();
        UserService service = githubConfig.getUserService();
        Call<User> userCall = service.getUser(name);

        userCall.enqueue(new Callback<User>() {
             @Override
             public void onResponse(Call<User> call, Response<User> response) {
                 User user = response.body();
                 TextView txtName = findViewById(R.id.txt_nome);
                 TextView login = findViewById(R.id.txt_login);
                 TextView empresa = findViewById(R.id.txt_empresa);
                 TextView blog = findViewById(R.id.txt_blog);
                 TextView local = findViewById(R.id.txt_local);
                 TextView email = findViewById(R.id.txt_email);
                 TextView biografia = findViewById(R.id.txt_biografia);
                 TextView numeroRepositorios = findViewById(R.id.txt_numero_repositorios);
                 TextView numeroSeguidores = findViewById(R.id.txt_numero_seguidores);

                 if(user != null){
                     txtName.setText(user.getName());
                     login.setText(user.getLogin());
                     empresa.setText(user.getCompany());
                     blog.setText(user.getBlog());
                     local.setText(user.getLocation());
                     email.setText(user.getEmail());
                     biografia.setText(user.getBio());
                     numeroRepositorios.setText(user.getPublic_repos());
                     numeroSeguidores.setText(user.getFollowers());
                 }
             }

             @Override
             public void onFailure(Call<User> call, Throwable t) {
                 Toast.makeText(UserActivity.this, "Erro", Toast.LENGTH_SHORT).show();
             }
         });


    }
}