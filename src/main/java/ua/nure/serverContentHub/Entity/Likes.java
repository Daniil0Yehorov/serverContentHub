package ua.nure.serverContentHub.Entity;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import ua.nure.serverContentHub.LocalDateTimeAdapter.LocalDateTimeAdapter;

import java.time.LocalDateTime;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Likes")
public class Likes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,name = "id")
    private int id;

    @XmlTransient
    @ManyToOne
    @JoinColumn(name = "UserID", nullable = false)
    private User user;

    @XmlTransient
    @ManyToOne
    @JoinColumn(name = "PostID", nullable = false)
    private Post post;

    @Column(nullable = false,name = "Like_Date")
    @XmlElement
    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    private LocalDateTime LikeDate;

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

    public LocalDateTime getLikeDate() {
        return LikeDate;
    }

    public void setLikeDate(LocalDateTime likeDate) {
        this.LikeDate = likeDate;
    }

    public Likes(int id, User user, Post post, LocalDateTime likeDate) {
        this.id = id;
        this.user = user;
        this.post = post;
        this.LikeDate = likeDate;
    }

    @Override
    public String toString() {
        return "like{" +
                "id=" + id +
                ", User=" + user +
                ", Post=" + post +
                ", LikeDate=" + LikeDate +
                '}';
    }
    public Likes(){}
}
