package ua.nure.serverContentHub.Entity;


import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;
import ua.nure.serverContentHub.Entity.Enum.ComplaintStatus;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Complaint")
public class Complaint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "UserID")
    private User user;

    @XmlTransient
    @ManyToOne
    @JoinColumn(name = "PostID")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "profile_UserID")
    private Profile profile;

    @Column(length = 65535, nullable = false)
    @XmlElement
    private String Reason;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @XmlElement
    private ComplaintStatus Status;

    public Complaint(int id, User user, Post post,
                     Profile profile, String reason, ComplaintStatus status) {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
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
    public Complaint(){}
}