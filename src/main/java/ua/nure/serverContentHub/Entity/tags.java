package ua.nure.serverContentHub.Entity;


import jakarta.persistence.*;

import java.util.Set;

@Entity
public class tags {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,name = "id")
    private int id;

    @Column(unique = true, nullable = false,name="name")
    private String name;

    @OneToMany(mappedBy = "tags")
    private Set<profile_has_tags> phs;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<profile_has_tags> getPhs() {
        return phs;
    }

    public void setPhs(Set<profile_has_tags> phs) {
        this.phs = phs;
    }

    public tags(int id, String name, Set<profile_has_tags> phs) {
        this.id = id;
        this.name = name;
        this.phs = phs;
    }

    @Override
    public String toString() {
        return "tags{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phs=" + phs +
                '}';
    }
}