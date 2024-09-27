package com.example.loginteste.data.model;

public class User {

    private String userId;
    private String nome;
    private String cnpj;
    private String estado;
    private String cpf;
    private String username;
    private String lojaId;
    private String lojaNome;
    private String longitude;
    private String latitude;
    private String role;
    private String message;

    public User(String userId, String nome, String cnpj, String estado, String cpf, String username,
                String lojaId, String lojaNome, String longitude, String latitude, String role, String message) {
        this.userId = userId;
        this.nome = nome;
        this.cnpj = cnpj;
        this.estado = estado;
        this.cpf = cpf;
        this.username = username;
        this.lojaId = lojaId;
        this.lojaNome = lojaNome;
        this.longitude = longitude;
        this.latitude = latitude;
        this.role = role;
        this.message = message;
    }

    public String getUserId() { return userId; }

    public String getNome() {
        return nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getEstado() {
        return estado;
    }

    public String getCpf() {
        return cpf;
    }

    public String getUsername() {
        return username;
    }

    public String getLojaId() {
        return lojaId;
    }

    public String getLojaNome() {
        return lojaNome;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getRole() {
        return role;
    }

    public String getMessage() {
        return message;
    }
}
