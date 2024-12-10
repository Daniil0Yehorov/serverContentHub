package ua.nure.serverContentHub.Entity;

import jakarta.persistence.*;

import java.util.Date;


@Entity
public class subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "UserID", nullable = false)
    private user user;

    @ManyToOne
    @JoinColumn(name = "CreatorID", nullable = false)
    private user creator;

    @Column(nullable = false)
    private Date subscriptionDate;

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

    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

    public subscription(int id, user user, user creator, Date subscriptionDate) {
        this.id = id;
        this.user = user;
        this.creator = creator;
        this.subscriptionDate = subscriptionDate;
    }

    @Override
    public String toString() {
        return "subscription{" +
                "id=" + id +
                ", User=" + user +
                ", creator=" + creator +
                ", subscriptionDate=" + subscriptionDate +
                '}';
    }
}