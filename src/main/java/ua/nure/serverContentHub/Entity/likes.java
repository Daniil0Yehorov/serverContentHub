package ua.nure.serverContentHub.Entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;
@Entity
public class likes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "UserID", nullable = false)
    private user user;

    @ManyToOne
    @JoinColumn(name = "PostID", nullable = false)
    private post post;

    @Column(nullable = false,name = "Like_Date")
    private LocalDateTime LikeDate;

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

    public LocalDateTime getLikeDate() {
        return LikeDate;
    }

    public void setLikeDate(LocalDateTime likeDate) {
        this.LikeDate = likeDate;
    }

    public likes(int id, user user, post post, LocalDateTime likeDate) {
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
    public likes(){}
}
