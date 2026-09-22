package com.matrimony.soul.sync.unsync.dto;

import com.matrimony.soul.sync.unsync.domain.Gender;
import com.matrimony.soul.sync.unsync.domain.Religion;
import com.matrimony.soul.sync.unsync.domain.SoulStatus;

public class UserDTO {
    private int id;
    private String name;
    private String username;
    private String email;
    private String contact;
    private Gender gender;
    private Religion religion;
    private SoulStatus soul_status;
    private String profile_pic;
    private int partners;

    public UserDTO(){}
    public UserDTO(int id, String name, String username, String email, String contact, Gender gender, Religion religion, SoulStatus soul_status, String profile_pic, int partners) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.contact = contact;
        this.gender = gender;
        this.religion = religion;
        this.soul_status = soul_status;
        this.profile_pic = profile_pic;
        this.partners = partners;
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

    public Religion getReligion() {
        return religion;
    }

    public void setReligion(Religion religion) {
        this.religion = religion;
    }

    public SoulStatus getSoul_status() {
        return soul_status;
    }

    public void setSoul_status(SoulStatus soul_status) {
        this.soul_status = soul_status;
    }

    public String getProfile_pic() {
        return profile_pic;
    }

    public void setProfile_pic(String profile_pic) {
        this.profile_pic = profile_pic;
    }

    public int getPartners() {
        return partners;
    }

    public void setPartners(int partners) {
        this.partners = partners;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", contact='" + contact + '\'' +
                ", gender=" + gender +
                ", religion=" + religion +
                ", soul_status=" + soul_status +
                ", profile_pic='" + profile_pic + '\'' +
                ", partners=" + partners +
                '}';
    }
}
