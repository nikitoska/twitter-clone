package net.nikitos.twit.entity;

import net.nikitos.twit.annotation.UniqueUsername;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Proxy;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Integer id;
    @Size(min = 3, message = "at least 3 characters")
    @Column(unique = true)
    @UniqueUsername(message = "Such username already exist!")
    private String name;
    @Size(min = 1, message = "invalid email address")
    @Email(message = "invalid email address")
    private String email;
    @Size(min = 3, message = "at least 3 characters")
    private String password;
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Twit> twits;

    @ManyToMany
    @JoinTable
    private List<Role> roles;

    private boolean enabled;

    @OneToMany(mappedBy = "parent", fetch = FetchType.EAGER, cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.REMOVE})
    private List<User> followers;

    @ManyToOne(fetch = FetchType.EAGER)
    private User parent;

    public List<User> getFollowers() {
        return followers;
    }

    public void setFollowers(List<User> followers) {
        this.followers = followers;
    }

    public User getParent() {
        return parent;
    }

    public void setParent(User parent) {
        this.parent = parent;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Twit> getTwits() {
        return twits;
    }

    public void setTwits(List<Twit> twits) {
        this.twits = twits;
    }

}
