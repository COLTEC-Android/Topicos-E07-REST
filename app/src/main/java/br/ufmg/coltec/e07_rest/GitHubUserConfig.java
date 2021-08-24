package br.ufmg.coltec.e07_rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GitHubUserConfig {

    // Objeto que fará o acesso a API do serviço
    private Retrofit retrofit;

    public GitHubUserConfig() {

        // configurando o retrofit para um determinado serviço
        this.retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

    public Retrofit getRetrofit() {
        return retrofit;
    }
}
