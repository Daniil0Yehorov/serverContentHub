package ua.nure.serverContentHub.Entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;


@Entity
public class subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "UserID", nullable = false)
    private user user;

    @ManyToOne
    @JoinColumn(name = "CreatorID", nullable = false)
    private user creator;

    @Column(nullable = false,name="Subscription_Date")
    private LocalDateTime SubscriptionDate;

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

    public LocalDateTime getSubscriptionDate() {
        return SubscriptionDate;
    }

    public void setSubscriptionDate(LocalDateTime subscriptionDate) {
        this.SubscriptionDate = subscriptionDate;
    }

    public subscription(int id, user user, user creator, LocalDateTime subscriptionDate) {
        this.id = id;
        this.user = user;
        this.creator = creator;
        this.SubscriptionDate = subscriptionDate;
    }

    @Override
    public String toString() {
        return "subscription{" +
                "id=" + id +
                ", User=" + user +
                ", creator=" + creator +
                ", subscriptionDate=" + SubscriptionDate +
                '}';
    }
}