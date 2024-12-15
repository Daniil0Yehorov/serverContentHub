package ua.nure.serverContentHub.Entity;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import ua.nure.serverContentHub.LocalDateTimeAdapter.LocalDateTimeAdapter;

import java.time.LocalDateTime;


@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Subscription")
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "UserID", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "CreatorID", nullable = false)
    private User creator;

    @Column(nullable = false,name="Subscription_Date")
    @XmlElement
    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    private LocalDateTime SubscriptionDate;

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

    public LocalDateTime getSubscriptionDate() {
        return SubscriptionDate;
    }

    public void setSubscriptionDate(LocalDateTime subscriptionDate) {
        this.SubscriptionDate = subscriptionDate;
    }

    public Subscription(int id, User user, User creator, LocalDateTime subscriptionDate) {
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
    public Subscription(){}
}