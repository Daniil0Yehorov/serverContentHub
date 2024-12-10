package ua.nure.serverContentHub.Entity;

import jakarta.persistence.*;

@Entity
public class profile_has_tags {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    @ManyToOne
    @JoinColumn(name = "profile_UserID")
    private profile profile;

    @ManyToOne
    @JoinColumn(name = "tags_id")
    private tags tags;

    public profile getProfile() {
        return profile;
    }

    public void setProfile(profile profile) {
        this.profile = profile;
    }

    public tags getTags() {
        return tags;
    }

    public void setTags(tags tags) {
        this.tags = tags;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "profile_has_tags{" +
                "id=" + id +
                ", Profile=" + profile +
                ", Tags=" + tags +
                '}';
    }

    public profile_has_tags(int id, profile profile, tags tags) {
        this.id = id;
        this.profile = profile;
        this.tags = tags;
    }
}
