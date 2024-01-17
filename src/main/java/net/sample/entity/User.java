package net.sample.entity;

import lombok.Data;

@Data
public class User {
    private String gender;
    private Name name;
    private Location location;
    private String email;
    private Login login;
    private long registered;
    private long dob;
    private String phone;
    private String cell;
    private Identity id;
    private Picture picture;
    private String nat;
}
