package net.nikitos.twit.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;


@Entity
public class Twit {

    @Id
    @GeneratedValue
    private Integer id;

    private Date date;
    @Size(min = 1, message = "at least one character")
    private String description;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
