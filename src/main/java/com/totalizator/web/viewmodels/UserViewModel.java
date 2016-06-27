package com.totalizator.web.viewmodels;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

/**
 * Created by Andrei Savchuk.
 */
@JsonAutoDetect
public class UserViewModel {
    private long id;
    private String userName = "";
    private String password = "";
    private String mail = "";
    private String purse = "";
    private boolean enabled;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPurse() {
        return purse;
    }

    public void setPurse(String purse) {
        this.purse = purse;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
