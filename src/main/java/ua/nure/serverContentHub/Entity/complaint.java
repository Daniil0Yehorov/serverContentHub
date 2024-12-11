package ua.nure.serverContentHub.Entity;


import jakarta.persistence.*;
import ua.nure.serverContentHub.Entity.Enum.ComplaintStatus;

@Entity
public class complaint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "UserID")
    private user user;

    @ManyToOne
    @JoinColumn(name = "PostID")
    private post post;

    @ManyToOne
    @JoinColumn(name = "profile_UserID")
    private profile profile;

    @Column(length = 65535, nullable = false)
    private String Reason;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ComplaintStatus Status;

    public complaint(int id, user user, post post,
                     profile profile, String reason, ComplaintStatus status) {
        this.id = id;
        this.user = user;
        this.post = post;
        this.profile = profile;
        this.Reason = reason;
        this.Status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public user getUser() {
        return user;
    }

    public void setUser(user user) {
        this.user = user;
    }

    public post getPost() {
        return post;
    }

    public void setPost(post post) {
        this.post = post;
    }

    public profile getProfile() {
        return profile;
    }

    public void setProfile(profile profile) {
        this.profile = profile;
    }

    public String getReason() {
        return Reason;
    }

    public void setReason(String reason) {
        this.Reason = reason;
    }

    public ComplaintStatus getStatus() {
        return Status;
    }

    public void setStatus(ComplaintStatus status) {
        this.Status = status;
    }

    @Override
    public String toString() {
        return "complaint{" +
                "id=" + id +
                ", User=" + user +
                ", Post=" + post +
                ", Profile=" + profile +
                ", Reason='" + Reason + '\'' +
                ", Status=" + Status +
                '}';
    }
}