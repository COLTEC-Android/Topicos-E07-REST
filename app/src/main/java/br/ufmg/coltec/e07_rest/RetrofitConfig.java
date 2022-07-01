package br.ufmg.coltec.e07_rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConfig {

    private static RetrofitConfig instance;
    private Retrofit retrofit;

    public static synchronized RetrofitConfig getInstance(){
        if(instance == null)
            instance = new RetrofitConfig();

        return instance;
    }
    private RetrofitConfig(){
        this.retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    public GitService getGitService(){
        return this.retrofit.create(GitService.class);
    }
}
