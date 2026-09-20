package com.matrimony.soul.sync.unsync.domain;

public class User {
    private int id;
    private String name;
    private String username;
    private String email;
    private String contact;
    private Gender gender;
    private String password_hash;
    private Role role;
    private Religion religion;
    private SoulStatus soulStatus;
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

    public Enum<Gender> getGender() {
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

    public Enum<Role> getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Enum<Religion> getReligion() {
        return religion;
    }

    public void setReligion(Religion religion) {
        this.religion = religion;
    }

    public Enum<SoulStatus> getSoulStatus() {
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
