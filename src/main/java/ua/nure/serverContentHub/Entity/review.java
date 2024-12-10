package ua.nure.serverContentHub.Entity;


import jakarta.persistence.*;
import ua.nure.serverContentHub.Entity.Enum.ReviewStatus;

import java.util.Date;

@Entity
public class review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "UserID", nullable = false)
    private user user;

    @ManyToOne
    @JoinColumn(name = "CreatorID", nullable = false)
    private user creator;

    @Column(unique = true, length = 65535)
    private String Text;

    @Column(nullable = false)
    private int Rating;

    @Column(nullable = false)
    private Date ReviewDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ReviewStatus Status;

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

    public user getCreator() {
        return creator;
    }

    public void setCreator(user creator) {
        this.creator = creator;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        this.Text = text;
    }

    public int getRating() {
        return Rating;
    }

    public void setRating(int rating) {
        this.Rating = rating;
    }

    public Date getReviewDate() {
        return ReviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        this.ReviewDate = reviewDate;
    }

    public ReviewStatus getStatus() {
        return Status;
    }

    public void setStatus(ReviewStatus status) {
        this.Status = status;
    }

    public review(int id, user user, user creator, String text,
                  int rating, Date reviewDate, ReviewStatus status) {
        this.id = id;
        this.user = user;
        this.creator = creator;
        this.Text = text;
        this.Rating = rating;
        this.ReviewDate = reviewDate;
        this.Status = status;
    }

    @Override
    public String toString() {
        return "review{" +
                "id=" + id +
                ", User=" + user +
                ", creator=" + creator +
                ", Text='" + Text + '\'' +
                ", Rating=" + Rating +
                ", ReviewDate=" + ReviewDate +
                ", Status=" + Status +
                '}';
    }
}