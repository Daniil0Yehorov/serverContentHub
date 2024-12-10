package ua.nure.serverContentHub.Entity;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "profile_UserID", nullable = false)
    private profile profile;

    @Column(nullable = false, length =65535)
    private String content;

    @Column(nullable = false)
    private Date publishDate;

    private int likeCount;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<ua.nure.serverContentHub.Entity.likes> likes;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<complaint> complaints;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public profile getProfile() {
        return profile;
    }

    public void setProfile(profile profile) {
        this.profile = profile;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public List<ua.nure.serverContentHub.Entity.likes> getLikes() {
        return likes;
    }

    public void setLikes(List<ua.nure.serverContentHub.Entity.likes> likes) {
        this.likes = likes;
    }

    public List<complaint> getComplaints() {
        return complaints;
    }

    public void setComplaints(List<complaint> complaints) {
        this.complaints = complaints;
    }

    public post(int id, profile profile, String content, Date publishDate,
                int likeCount, List<ua.nure.serverContentHub.Entity.likes> likes, List<complaint> complaints) {
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
}
