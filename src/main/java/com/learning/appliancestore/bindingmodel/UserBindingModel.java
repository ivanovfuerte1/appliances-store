package com.learning.appliancestore.bindingmodel;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by ivanov on 1.4.2018 г..
 */
public class UserBindingModel {
    @NotNull
    private String email;

    @NotNull
    private String fullName;

    @NotNull
    private String password;

    @NotNull
    private String confirmPassword;

    private String enabled;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Size(min=3, max=30)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }
}
