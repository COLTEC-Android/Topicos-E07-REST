package users;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GitConfig {

    private Retrofit retrofit;

    public GitConfig(){
        this.retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/users/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

    public UsersService getUsersService(){
        return this.retrofit.create(UsersService.class);
    }
}
