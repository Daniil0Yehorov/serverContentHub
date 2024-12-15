package ua.nure.serverContentHub.Entity;


import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;

import java.util.Set;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Tags")
public class Tags {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,name = "id")
    private int id;

    @XmlTransient
    @OneToMany(mappedBy = "tags")
    private Set<Profile_has_tags> phs;

    @Column(unique = true, nullable = false,name="name")
    @XmlElement
    private String name;

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

    public Set<Profile_has_tags> getPhs() {
        return phs;
    }

    public void setPhs(Set<Profile_has_tags> phs) {
        this.phs = phs;
    }

    public Tags(int id, String name, Set<Profile_has_tags> phs) {
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
    public Tags(){}
}