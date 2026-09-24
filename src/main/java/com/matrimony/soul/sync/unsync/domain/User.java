package com.matrimony.soul.sync.unsync.domain;

import jakarta.validation.constraints.*;

public class User {
    private int id;

    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    private String name;

    @NotBlank(message = "Username is required")
    @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters")
    @Pattern(
            regexp = "^[a-zA-Z0-9_]+$",
            message = "Username can only contain letters, numbers and underscores"
    )
    private String username;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    @Size(max = 150, message = "Email cannot exceed 150 characters")
    private String email;

    @NotBlank(message = "Contact number is required")
    @Pattern(
            regexp = "^(?:\\+8801|01)[3-9]\\d{8}$",
            message = "Invalid Bangladesh contact number"
    )
    private String contact;

    @NotNull(message = "Gender is required")
    private Gender gender;

    @NotBlank(message = "Password is required")
    @Size(min = 8, max = 255, message = "Password must be between 8 and 255 characters")
    private String password_hash;

    @NotNull(message = "Role is required")
    private Role role;

    @NotNull(message = "Religion is required")
    private Religion religion;

    private SoulStatus soulStatus;

    @Size(max = 500, message = "Profile picture URL cannot exceed 500 characters")
    private String profile_pic;

    private boolean visibility;

    public User(){}

    public User(int id, String name, String username, String email, String contact, Gender gender, String password_hash, Role role, Religion religion, SoulStatus soulStatus, String profile_pic, boolean visibility) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.contact = contact;
        this.gender = gender;
        this.password_hash = password_hash;
        this.role = role;
        this.religion = religion;
        this.soulStatus = soulStatus;
        this.profile_pic = profile_pic;
        this.visibility = visibility;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getPassword_hash() {
        return password_hash;
    }

    public void setPassword_hash(String password_hash) {
        this.password_hash = password_hash;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Religion getReligion() {
        return religion;
    }

    public void setReligion(Religion religion) {
        this.religion = religion;
    }

    public SoulStatus getSoulStatus() {
        return soulStatus;
    }

    public void setSoulStatus(SoulStatus soulStatus) {
        this.soulStatus = soulStatus;
    }

    public String getProfile_pic() {
        return profile_pic;
    }

    public void setProfile_pic(String profile_pic) {
        this.profile_pic = profile_pic;
    }

    public boolean getVisibility() {
        return visibility;
    }

    public void setVisibility(boolean visibility) {
        this.visibility = visibility;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", contact='" + contact + '\'' +
                ", gender=" + gender +
                ", password_hash='" + password_hash + '\'' +
                ", role=" + role +
                ", religion=" + religion +
                ", soulStatus=" + soulStatus +
                ", profile_pic='" + profile_pic + '\'' +
                ", visibility=" + visibility +
                '}';
    }
}
