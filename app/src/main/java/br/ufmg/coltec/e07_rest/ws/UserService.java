package br.ufmg.coltec.e07_rest.ws;
import br.ufmg.coltec.e07_rest.models.User;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface UserService {

    @GET("{user}")
    public Call<User> getUser(@Path("user")String user);
}
