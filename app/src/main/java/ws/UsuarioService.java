package ws;

import java.util.List;

import models.Usuario;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface UsuarioService {

    @GET("users/{user}")
    public Call<Usuario> getUsuario(@Path("user") String user);

}
