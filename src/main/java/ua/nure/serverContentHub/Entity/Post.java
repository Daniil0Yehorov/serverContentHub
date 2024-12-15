package ua.nure.serverContentHub.Entity;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import ua.nure.serverContentHub.LocalDateTimeAdapter.LocalDateTimeAdapter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,name = "id")
    private int id;

    @XmlTransient
    @ManyToOne
    @JoinColumn(name = "profile_UserID", nullable = false)
    private Profile profile;

    @Column(nullable = false, length =65535)
    @XmlElement
    private String content;

    @Column(nullable = false,name = "Publish_Date")
    @XmlElement
    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    private LocalDateTime publishDate;

    @XmlTransient
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Likes> likes;

    @XmlTransient
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Complaint> complaints;

    @Column(nullable = false,name = "Like_Count")
    @XmlElement
    private int likeCount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDateTime publishDate) {
        this.publishDate = publishDate;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public List<Likes> getLikes() {
        return likes;
    }

    public void setLikes(List<Likes> likes) {
        this.likes = likes;
    }

    public List<Complaint> getComplaints() {
        return complaints;
    }

    public void setComplaints(List<Complaint> complaints) {
        this.complaints = complaints;
    }

    public Post(int id, Profile profile, String content, LocalDateTime publishDate,
                int likeCount, List<Likes> likes, List<Complaint> complaints) {
        this.id = id;
        this.profile = profile;
        this.content = content;
        this.publishDate = publishDate;
        this.likeCount = likeCount;
        this.likes = likes;
        this.complaints = complaints;
    }

    @Override
    public String toString() {
        return "post{" +
                "id=" + id +
                ", Profile=" + profile +
                ", content='" + content + '\'' +
                ", publishDate=" + publishDate +
                ", likeCount=" + likeCount +
                ", likes=" + likes +
                ", complaints=" + complaints +
                '}';
    }
    public Post(){}
}
