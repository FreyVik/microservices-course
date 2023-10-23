package com.freyvik.clients.model;

public class ResultAuth {

    private String access_token;

    public ResultAuth() {
    }

    public ResultAuth(String access_token) {
        this.access_token = access_token;
    }

    public String getAccess_token() {
        return access_token;
    }
    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }
}
