package ua.nure.serverContentHub.Entity;

import jakarta.persistence.*;
import ua.nure.serverContentHub.Entity.Enum.Role;
import ua.nure.serverContentHub.Entity.Enum.User_Status;
import java.util.Date;
import java.util.List;

@Entity
public class user {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true)
    private int id;

    @Column(unique = true, nullable = false)
    private String login;

    @Column(nullable = false)
    private String Password;

    @Column(unique = true, nullable = false)
    private String Name;

    @Column(unique = true, nullable = false)
    private String Email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false,name = "Role")
    private Role role;

    @Column(nullable = false)
    private Date RegistrationDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private User_Status Status;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private profile profile;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<complaint> complaints;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<review> reviews;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<subscription> subscriptions;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ua.nure.serverContentHub.Entity.likes> likes;

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

    public Date getRegistrationDate() {
        return RegistrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.RegistrationDate = registrationDate;
    }

    public User_Status getStatus() {
        return Status;
    }

    public void setStatus(User_Status status) {
        Status = status;
    }

    public profile getProfile() {
        return profile;
    }

    public void setProfile(profile profile) {
        this.profile = profile;
    }

    public List<complaint> getComplaints() {
        return complaints;
    }

    public void setComplaints(List<complaint> complaints) {
        this.complaints = complaints;
    }

    public List<review> getReviews() {
        return reviews;
    }

    public void setReviews(List<review> reviews) {
        this.reviews = reviews;
    }

    public List<subscription> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(List<subscription> subscriptions) {
        this.subscriptions = subscriptions;
    }

    public List<ua.nure.serverContentHub.Entity.likes> getLikes() {
        return likes;
    }

    public void setLikes(List<ua.nure.serverContentHub.Entity.likes> likes) {
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

    public user(int id, String login, String password, String name, String email,
                Role role, Date registrationDate, User_Status status, profile profile,
                List<complaint> complaints, List<review> reviews, List<subscription> subscriptions, List<ua.nure.serverContentHub.Entity.likes> likes) {
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
}
