package ua.nure.serverContentHub.Entity;

import jakarta.persistence.*;
import java.util.Date;
@Entity
public class likes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "UserID", nullable = false)
    private user user;

    @ManyToOne
    @JoinColumn(name = "PostID", nullable = false)
    private post post;

    @Column(nullable = false)
    private Date LikeDate;

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

    public Date getLikeDate() {
        return LikeDate;
    }

    public void setLikeDate(Date likeDate) {
        this.LikeDate = likeDate;
    }

    public likes(int id, user user, post post, Date likeDate) {
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
}
