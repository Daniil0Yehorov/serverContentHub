package ua.nure.serverContentHub.Entity;

import jakarta.persistence.*;
import ua.nure.serverContentHub.Entity.Enum.Role;
import ua.nure.serverContentHub.Entity.Enum.User_Status;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,name = "id")
    private int id;

    @Column(unique = true, nullable = false,name = "login")
    private String login;

    @Column(nullable = false,name = "Password")
    private String Password;

    @Column(unique = true, nullable = false,name = "Name")
    private String Name;

    @Column(unique = true, nullable = false,name = "Email")
    private String Email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false,name = "Role")
    private Role role;

    @Column(nullable = false,name = "Registration_Date")
    private LocalDateTime RegistrationDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private User_Status Status;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Profile profile;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Complaint> complaints;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Subscription> subscriptions;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Likes> likes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        this.Password = password;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public LocalDateTime getRegistrationDate() {
        return RegistrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.RegistrationDate = registrationDate;
    }

    public User_Status getStatus() {
        return Status;
    }

    public void setStatus(User_Status status) {
        Status = status;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public List<Complaint> getComplaints() {
        return complaints;
    }

    public void setComplaints(List<Complaint> complaints) {
        this.complaints = complaints;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public List<Subscription> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(List<Subscription> subscriptions) {
        this.subscriptions = subscriptions;
    }

    public List<Likes> getLikes() {
        return likes;
    }

    public void setLikes(List<Likes> likes) {
        this.likes = likes;
    }

    @Override
    public String toString() {
        return "user{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", Password='" + Password + '\'' +
                ", Name='" + Name + '\'' +
                ", Email='" + Email + '\'' +
                ", role=" + role +
                ", RegistrationDate=" + RegistrationDate +
                ", Status=" + Status +
                ", Profile=" + profile +
                ", complaints=" + complaints +
                ", reviews=" + reviews +
                ", subscriptions=" + subscriptions +
                ", likes=" + likes +
                '}';
    }

    public User(int id, String login, String password, String name, String email,
                Role role, LocalDateTime registrationDate, User_Status status, Profile profile,
                List<Complaint> complaints, List<Review> reviews, List<Subscription> subscriptions, List<Likes> likes) {
        this.id = id;
        this.login = login;
        this.Password = password;
        this.Name = name;
        this.Email = email;
        this.role = role;
        this.RegistrationDate = registrationDate;
        this.Status = status;
        this.profile = profile;
        this.complaints = complaints;
        this.reviews = reviews;
        this.subscriptions = subscriptions;
        this.likes = likes;
    }
    public User() {}
}