package com.jfam.mobility;

import java.util.List;

/**
 * Created by Zeelo on 2/10/2019.
 */
public class UsersPool {
    String POOLID;
    List<User> users;

    public String getPOOLID() {
        return POOLID;
    }

    public void setPOOLID(String POOLID) {
        this.POOLID = POOLID;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
