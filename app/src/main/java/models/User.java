package models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

// Serializada para ser enviado para outra activity
public class User implements Serializable {

    private String login;
    @SerializedName("name")
    private String nome;
    @SerializedName("company")
    private String empresa;
    private String blog;
    @SerializedName("location")
    private String local;
    private String email;
    @SerializedName("bio")
    private String biografia;
    @SerializedName("public_repos")
    private String numeroRepositorios;
    @SerializedName("followers")
    private String numeroSeguidores;
    @SerializedName("avatar_url")
    private String avatarUrl;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public String getNumeroRepositorios() {
        return numeroRepositorios;
    }

    public void setNumeroRepositorios(String numeroRepositorios) {
        this.numeroRepositorios = numeroRepositorios;
    }

    public String getNumeroSeguidores() {
        return numeroSeguidores;
    }

    public void setNumeroSeguidores(String numeroSeguidores) {
        this.numeroSeguidores = numeroSeguidores;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", nome='" + nome + '\'' +
                ", empresa='" + empresa + '\'' +
                ", blog='" + blog + '\'' +
                ", local='" + local + '\'' +
                ", email='" + email + '\'' +
                ", biografia='" + biografia + '\'' +
                ", numeroRepositorios=" + numeroRepositorios +
                ", numeroSeguidores=" + numeroSeguidores +
                '}';
    }
}
