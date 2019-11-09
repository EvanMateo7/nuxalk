package com.mysql.mysql.model;

import java.util.Set;

import com.mysql.mysql.model.AppUser;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="role")
public class Role {
    @Id
    @GeneratedValue
    private int roleID;
    
    @NotNull
    @Column(unique=true)
    private String role;

    @NotNull
    private String roleDescription;

    @ManyToMany(mappedBy = "userRoles")
    Set<AppUser> users;

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    
}