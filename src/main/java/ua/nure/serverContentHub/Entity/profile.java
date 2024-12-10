package ua.nure.serverContentHub.Entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
public class profile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToOne
    @JoinColumn(name = "UserID")
    private user user;

    @Column(nullable = false,length = 65535)
    private String Description;
    //default
    private String AvatarURL;

    @Column( length = 65535)
    private String Tiktok;

    @Column( length = 65535)
    private String Instagram;

    @Column(length = 65535)
    private String Twitch;

    @Column( length = 65535)
    private String Youtube;
    //default
    private int SubscribersCount;
    //default
    private int Rating;
    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<post> posts;

    @OneToMany(mappedBy="profile")
    private Set<profile_has_tags> phs;

    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL)
    private List<complaint> complaints;


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

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        this.Description = description;
    }

    public String getAvatarURL() {
        return AvatarURL;
    }

    public void setAvatarURL(String avatarURL) {
        this.AvatarURL = avatarURL;
    }

    public String getTiktok() {
        return Tiktok;
    }

    public void setTiktok(String tiktok) {
        this.Tiktok = tiktok;
    }

    public String getInstagram() {
        return Instagram;
    }

    public void setInstagram(String instagram) {
        this.Instagram = instagram;
    }

    public String getTwitch() {
        return Twitch;
    }

    public void setTwitch(String twitch) {
        this.Twitch = twitch;
    }

    public String getYoutube() {
        return Youtube;
    }

    public void setYoutube(String youtube) {
        this.Youtube = youtube;
    }

    public int getSubscribersCount() {
        return SubscribersCount;
    }

    public void setSubscribersCount(int subscribersCount) {
        this.SubscribersCount = subscribersCount;
    }

    public int getRating() {
        return Rating;
    }

    public void setRating(int rating) {
        this.Rating = rating;
    }

    public List<post> getPosts() {
        return posts;
    }

    public void setPosts(List<post> posts) {
        this.posts = posts;
    }

    public Set<profile_has_tags> getPhs() {
        return phs;
    }

    public void setPhs(Set<profile_has_tags> phs) {
        this.phs = phs;
    }

    public List<complaint> getComplaints() {
        return complaints;
    }

    public void setComplaints(List<complaint> complaints) {
        this.complaints = complaints;
    }

    @Override
    public String toString() {
        return "profile{" +
                "id=" + id +
                ", user=" + user +
                ", Description='" + Description + '\'' +
                ", AvatarURL='" + AvatarURL + '\'' +
                ", Tiktok='" + Tiktok + '\'' +
                ", Instagram='" + Instagram + '\'' +
                ", Twitch='" + Twitch + '\'' +
                ", Youtube='" + Youtube + '\'' +
                ", SubscribersCount=" + SubscribersCount +
                ", Rating=" + Rating +
                ", posts=" + posts +
                ", phs=" + phs +
                ", complaints=" + complaints +
                '}';
    }

    public profile(int id, ua.nure.serverContentHub.Entity.user user, String description,
                   String avatarURL, String tiktok, String instagram, String twitch,
                   String youtube, int subscribersCount, int rating, List<post> posts, Set<profile_has_tags> phs, List<complaint> complaints) {
        this.id = id;
        this.user = user;
        this.Description = description;
        this.AvatarURL = avatarURL;
        this.Tiktok = tiktok;
        this.Instagram = instagram;
        this.Twitch = twitch;
        this.Youtube = youtube;
        this.SubscribersCount = subscribersCount;
        this.Rating = rating;
        this.posts = posts;
        this.phs = phs;
        this.complaints = complaints;
    }
}
