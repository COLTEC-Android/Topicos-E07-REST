package br.ufmg.coltec.e07_rest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import models.GitHubUser;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText inputUserName = this.findViewById(R.id.input_user_name);
        Button btnSearch = this.findViewById(R.id.btn_search);
        TextView lblName = this.findViewById(R.id.lbl_name);
        TextView lblLogin = this.findViewById(R.id.lbl_login);
        TextView lblCompany = this.findViewById(R.id.lbl_company);
        TextView lblBio = this.findViewById(R.id.lbl_bio);
        TextView lblBlog = this.findViewById(R.id.lbl_blog);
        TextView lblFollowers = this.findViewById(R.id.lbl_followers);
        TextView lblLocation = this.findViewById(R.id.lbl_location);

        btnSearch.setOnClickListener(view ->  {
            String userName = inputUserName.getText().toString();

            GitHubUserService gitHubUserService = new GitHubUserConfig()
                    .getGitHubUserService();
            Call<GitHubUser> gitHubUserCall = gitHubUserService.getUser(userName);

            gitHubUserCall.enqueue(new Callback<GitHubUser>() {
                @Override
                public void onResponse(Call<GitHubUser> call, Response<GitHubUser> response) {
                    // sucesso
                    Toast.makeText(MainActivity.this, "Sucesso", Toast.LENGTH_SHORT).show();

                    // recuperando dados da requisição
                    GitHubUser gitHubUser = response.body();

                    lblName.setText(gitHubUser.getName());
                    lblLogin.setText(gitHubUser.getLogin());
                    lblBio.setText(gitHubUser.getBio());
                    lblBlog.setText(gitHubUser.getBlog());
                    lblCompany.setText(gitHubUser.getCompany());
                    lblLocation.setText(gitHubUser.getLocation());
                    lblFollowers.setText(gitHubUser.getFollowers());
                }

                @Override
                public void onFailure(Call<GitHubUser> call, Throwable t) {
                    // falha
                    Toast.makeText(MainActivity.this, "Erro", Toast.LENGTH_SHORT).show();
                }
            });
        });
    }
}