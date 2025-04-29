package edu.eci.cvds.proyect.booking.persistency.entity;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import edu.eci.cvds.proyect.booking.GroupName;


@Document(collection = "Groups")
public class Group {
    @Id
    private Integer id;

    private Integer userId;

    private GroupName name;

    private Integer number;


    public Group(Integer id, Integer userId, GroupName name, Integer number) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.number = number;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public GroupName getName() {
        return name;
    }

    public void setName(GroupName name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    
}
