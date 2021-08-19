package br.ufmg.coltec.e07_rest.models;

import com.google.gson.annotations.SerializedName;

public class User {

    private String name;
    private String login;
    private String company;
    private String blog;
    private String location;
    private String email;
    private String bio;
    @SerializedName("public_repos")
    private Integer repos;
    private Integer followers;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Integer getRepos() {
        return repos;
    }

    public void setRepos(Integer repos) {
        this.repos = repos;
    }

    public Integer getFollowers() {
        return followers;
    }

    public void setFollowers(Integer followers) {
        this.followers = followers;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", company='" + company + '\'' +
                ", blog='" + blog + '\'' +
                ", location='" + location + '\'' +
                ", email='" + email + '\'' +
                ", bio='" + bio + '\'' +
                ", repos=" + repos +
                ", followers=" + followers +
                '}';
    }
}

//nome, login, empresa, blog, local, email (se houver), biografia, número de repositórios, e número de seguidores.