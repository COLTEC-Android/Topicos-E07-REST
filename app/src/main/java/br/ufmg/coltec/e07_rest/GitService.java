package br.ufmg.coltec.e07_rest;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitService {
    @GET("/users/{user}")
    public Call<User> getUser(@Path("user")String usuario);
}
