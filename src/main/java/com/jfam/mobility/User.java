package com.jfam.mobility;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zeelo on 2/10/2019.
 */
@Entity
public class User {
    public int getId1() {
        return id1;
    }

    public void setId1(int id1) {
        this.id1 = id1;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
                int id1;
    String id;
    String profilePhoto;
    String city;
    String state;
    String username;
    String firstName;
    String lastName;
    @Transient
    List<User> friendList;
    @Transient
    List<User> mutualConnections = new ArrayList<>();

    public User(){

    }
    public List<User> getMutualConnections() {
        return mutualConnections;
    }

    public void setMutualConnections(List<User> mutualConnections) {
        this.mutualConnections = mutualConnections;
    }

    public void setFriendList(List<User> friendList) {
        this.friendList = friendList;
    }

    public List<User> getFriendList() {
        return friendList;
    }



    public User(String id, String profilePhoto, String city, String state, String username, String firstName, String lastName) {
        friendList = new ArrayList<>();
        this.id = id;
        this.profilePhoto = profilePhoto;
        this.city = city;
        this.state = state;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void addFriend(User user){
        this.friendList.add(user);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
