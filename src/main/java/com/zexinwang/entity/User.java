package com.zexinwang.entity;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "sys_user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "organization_id")
    private Long organizationId;

    private String username;

    private String password;

    private String salt;

    @Column(name = "role_ids")
    private String roleIds;

    private Boolean locked;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return organization_id
     */
    public Long getOrganizationId() {
        return organizationId;
    }

    /**
     * @param organizationId
     */
    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    /**
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return salt
     */
    public String getSalt() {
        return salt;
    }

    /**
     * @param salt
     */
    public void setSalt(String salt) {
        this.salt = salt;
    }

    /**
     * @return role_ids
     */
    public String getRoleIds() {
        return roleIds;
    }

    /**
     * @param roleIds
     */
    public void setRoleIds(String roleIds) {
        this.roleIds = roleIds;
    }

    /**
     * @return locked
     */
    public Boolean getLocked() {
        return locked;
    }

    /**
     * @param locked
     */
    public void setLocked(Boolean locked) {
        this.locked = locked;
    }
}