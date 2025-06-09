package models;

import java.time.LocalDateTime;

public class User {
    private int userId;
    private String name;
    private String email;
    private String passwordHash;
    private Gender gender;
    private String contactNumber;
    private String address;
    private Role role;
    private LocalDateTime createdAt;

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", passwordHash='" + passwordHash + '\'' +
                ", gender=" + gender +
                ", contactNumber='" + contactNumber + '\'' +
                ", address='" + address + '\'' +
                ", role=" + role +
                ", createdAt=" + createdAt +
                '}';
    }

    public User() {
    }

    public User(int userId, String name, String email, String passwordHash, String gender, String contactNumber, String address, Role role, LocalDateTime createdAt) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.passwordHash = passwordHash;
        this.gender = Gender.valueOf(gender);
        this.contactNumber = contactNumber;
        this.address = address;
        this.role = role;
        this.createdAt = createdAt;
    }

    public enum Role {
        PASSENGER, FLIGHT_OWNER, ADMIN
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = Gender.valueOf(gender);
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
