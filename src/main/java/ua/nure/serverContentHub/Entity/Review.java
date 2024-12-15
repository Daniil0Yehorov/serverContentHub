package ua.nure.serverContentHub.Entity;


import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import ua.nure.serverContentHub.Entity.Enum.ReviewStatus;
import ua.nure.serverContentHub.LocalDateTimeAdapter.LocalDateTimeAdapter;

import java.time.LocalDateTime;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Review")
public class Review {
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
    @JoinColumn(name = "CreatorID", nullable = false)
    private User creator;

    @Column(unique = true, length = 65535)
    @XmlElement
    private String Text;

    @Column(nullable = false)
    @XmlElement
    private int Rating;

    @Column(nullable = false,name = "Review_Date")
    @XmlElement
    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    private LocalDateTime ReviewDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @XmlElement
    private ReviewStatus Status;

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

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
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

    public LocalDateTime getReviewDate() {
        return ReviewDate;
    }

    public void setReviewDate(LocalDateTime reviewDate) {
        this.ReviewDate = reviewDate;
    }

    public ReviewStatus getStatus() {
        return Status;
    }

    public void setStatus(ReviewStatus status) {
        this.Status = status;
    }

    public Review(int id, User user, User creator, String text,
                  int rating, LocalDateTime reviewDate, ReviewStatus status) {
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
    public Review() {}
}