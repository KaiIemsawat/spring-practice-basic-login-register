package com.practice.login_register.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table
public class User {

    /* ----- FIELDS ----- */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id; // Change name from userId to user_id

    @NotBlank(message = "Name can't be empty")
    @Size(min = 2, max = 255, message = "Name must be between 2 to 255 characters")
    private String userName;

    @NotBlank(message = "Email can't be empty")
    @Email(message = "Please provide a valid email address")
    private String email;

    @NotBlank(message = "Password can't be empty")
    @Size(min = 6, max = 24, message = "password need to be 6 to 24 characters")
    private String password;

    @Transient // Will not save this field in database
    @NotEmpty(message = "Confirm password can't be empty")
    private String confirmPassword;


    /* ----- TIMESTAMPS ----- */
    @Column(updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }

    /* ----- CONSTRUCTOR ----- */
    public User() {}
    public User(String userName, String email, String password, String confirmPassword) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    /* ----- GETTERS / SETTERS ----- */

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

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

    public Date getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
