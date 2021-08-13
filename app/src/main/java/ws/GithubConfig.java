package ws;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GithubConfig {

    private Retrofit retrofit;
    public GithubConfig(){
        this.retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public Retrofit getRetrofit(){
        return retrofit;
    }

    public UserService getUserService(){
        return this.retrofit.create(UserService.class);
    }
}
