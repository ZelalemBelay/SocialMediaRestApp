package com.jfam.mobility;

import org.slf4j.Logger;

import java.io.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Zeelo on 2/10/2019.
 */
public class UsersWareHouseService {

    static User u1 = new User("1", "URL1", "Dallas", "TX", "ZB86337", "Mark", "Antony");
    static User u2 = new User("2", "URL1", "Seatlle", "WA", "AMhir545", "Mark", "Antony");
    static User u3 = new User("3", "URL1", "Virginia beach", "VA", "Userhasdf4", "Mark", "Antony");
    static User u4 = new User("4", "URL1", "Irving", "TX", "GetUUi44", "Mark", "Antony");
    static User u5 = new User("5", "URL1", "Georgia", "AT", "Zb874fn", "Mark", "Antony");
    static User u6 = new User("6", "URL1", "Huston", "TX", "Giiie87f", "Mark", "Antony");
    static User u7 = new User("7", "URL1", "Miami", "FL", "Zela@gmm44", "Mark", "Antony");
    static User u8 = new User("8", "URL1", "Melbourne", "FL", "User123", "Mark", "Antony");
    static User u9 = new User("9", "URL1", "NewYork City", "NY", "Zela.bel", "Mark", "Antony");
    static User u10 = new User("10", "URL1", "Los Angeles", "CA", "User.34", "Mark", "Antony");
    static User u11 = new User("11", "URL1", "Irvine", "CA", "Log.Im", "Mark", "Antony");
    static User u12 = new User("12", "URL1", "Palm Bay", "FL", "MC5584", "Mark", "Antony");
    static User u13 = new User("13", "URL1", "San Antino", "TX", "ZB86332", "Mark", "Antony");
    static User u14 = new User("14", "URL1", "Fairfield", "IA", "U86h4j", "Mark", "Antony");
    static User u15 = new User("15", "URL1", "Dallas", "TX", "Mc12343", "Mark", "Antony");

   public static List<User> initialUsersList = new ArrayList<>();

    public List<User> addFriendToUser(User userToAdd, User holdingUser){
        holdingUser.addFriend(userToAdd);
        initialUsersList.add(userToAdd);
        if (!initialUsersList.contains(holdingUser)){
            initialUsersList.add(holdingUser);
        }
        return holdingUser.getFriendList();
    }

    public void populateUsers(){
        addFriendToUser(u2, u1);
        addFriendToUser(u3, u1);
        addFriendToUser(u4, u3);
        addFriendToUser(u5, u3);

        addFriendToUser(u7, u6);
        addFriendToUser(u8, u7);
        addFriendToUser(u9, u7);
        addFriendToUser(u10, u9);

        addFriendToUser(u12, u11);
        addFriendToUser(u13, u12);

        addFriendToUser(u15, u14);

    }


    public User getUserByUserName(String unm){
        System.out.println("Searching for "+ unm);
       return this.initialUsersList.stream()
                .filter(u -> u.getUsername().equalsIgnoreCase(unm)).findAny().get();
    }

    public List<User> getAllUsers() {
        return initialUsersList;
    }
}
