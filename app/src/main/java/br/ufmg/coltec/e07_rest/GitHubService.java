package br.ufmg.coltec.e07_rest;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubService {

    @GET("users/{login}")
    public Call<User> getUser(@Path("login") String login);

}
