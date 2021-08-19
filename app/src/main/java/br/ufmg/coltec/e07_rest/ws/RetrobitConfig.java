package br.ufmg.coltec.e07_rest.ws;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrobitConfig {

    private static Retrofit instance = new Retrofit.Builder()
            .baseUrl("https://api.github.com/users/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private static UserService service = instance.create(UserService.class);

    public static UserService getUserService(){
        return instance.create(UserService.class);
    }
}
