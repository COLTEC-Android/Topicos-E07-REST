package br.ufmg.coltec.e07_rest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import br.ufmg.coltec.e07_rest.models.User;
import br.ufmg.coltec.e07_rest.ws.RetrobitConfig;
import br.ufmg.coltec.e07_rest.ws.UserService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText txtUser = findViewById(R.id.txt_user);
        Button btnSearch = findViewById(R.id.btn_search);
        TextView txtName = findViewById(R.id.txt_name);
        TextView txtEmail = findViewById(R.id.txt_email);
        TextView txtLogin = findViewById(R.id.txt_login);
        TextView txtBlog = findViewById(R.id.txt_blog);
        TextView txtCompany = findViewById(R.id.txt_company);
        TextView txtLocation = findViewById(R.id.txt_location);
        TextView txtRepos = findViewById(R.id.txt_repos);
        TextView txtFollowers = findViewById(R.id.txt_followers);
        TextView txtBio = findViewById(R.id.txt_bio);


        btnSearch.setOnClickListener(view->{

            String gitUser = txtUser.getText().toString();
            UserService service = RetrobitConfig.getUserService();
            Call<User> userCall = service.getUser(gitUser);

            userCall.enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {

                    User user = response.body();

                    if(user != null) {
                        txtName.setText(user.getName());
                        txtEmail.setText(user.getEmail());
                        txtLogin.setText(user.getLogin());
                        txtBlog.setText(user.getBlog());
                        txtCompany.setText(user.getCompany());
                        txtLocation.setText(user.getLocation());
                        txtRepos.setText(user.getRepos().toString());
                        txtFollowers.setText(user.getFollowers().toString());
                        txtBio.setText(user.getBio());
                        Toast.makeText(MainActivity.this, "Usuário encontrado!", Toast.LENGTH_LONG).show();
                    }
                    else {
                        Toast.makeText(MainActivity.this, "O usuário não foi encontrado!", Toast.LENGTH_LONG).show();
                    }
                }
                @Override
                public void onFailure(Call<User> call, Throwable t) {
                    Toast.makeText(MainActivity.this, "Falha na busca do usuário", Toast.LENGTH_LONG).show();

                }
            });
        });

    }
}