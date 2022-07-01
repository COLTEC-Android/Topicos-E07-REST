package br.ufmg.coltec.e07_rest;

import java.io.Serializable;

public class User implements Serializable {
    private String login;
    private String name;
    private String company;
    private String blog;
    private String email;
    private String bio;
    private String location;
    private int public_repos;
    private int followers;

    public User(String login, String name, String company, String blog, String email, String bio, int public_repos, int followers, String location) {
        this.login = login;
        this.name = name;
        this.company = company;
        this.blog = blog;
        this.email = email;
        this.bio = bio;
        this.public_repos = public_repos;
        this.followers = followers;
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public String getLogin() {
        return login;
    }

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    public String getBlog() {
        return blog;
    }

    public String getEmail() {
        return email;
    }

    public String getBio() {
        return bio;
    }

    public int getPublic_repos() {
        return public_repos;
    }

    public int getFollowers() {
        return followers;
    }
}
