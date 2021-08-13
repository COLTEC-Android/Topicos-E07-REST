package users;

import models.User;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface UsersService {

    @GET("{user}")
    public Call<User> getUser(@Path("user")String user);
}
