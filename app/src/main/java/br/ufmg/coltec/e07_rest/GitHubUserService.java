package br.ufmg.coltec.e07_rest;

import models.GitHubUser;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubUserService {

    @GET("{userName}")
    public Call<GitHubUser> getUser(@Path("userName") String userName);


}
