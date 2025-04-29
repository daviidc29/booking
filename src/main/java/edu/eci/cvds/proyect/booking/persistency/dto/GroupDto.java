package edu.eci.cvds.proyect.booking.persistency.dto;

import edu.eci.cvds.proyect.booking.GroupName;

public class GroupDto {

    private Integer userId;

    private GroupName name;

    private Integer number;

    public GroupDto(Integer userId, GroupName name, Integer number) {
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

    
}
