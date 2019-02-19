package com.jfam.mobility;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Zeelo on 2/10/2019.
 */
public class UsersWareHouseService {

    static User u1 = new User("1", "http://www.venmond.com/demo/vendroid/img/avatar/big.jpg", "Dallas", "TX", "ZB86337", "Mark", "Antony");
    static User u2 = new User("2", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTLn1pxyOeB13Qr4lrifBqLo-Thcn6ExBDdVuniA78IEocdQYLEpw", "Seatlle", "WA", "AMhir545", "Thomas", "Mark");
    static User u3 = new User("3", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT-0VT_2DH-9RiF_5mwIxEKQS8u2VtoWeUI2iUHrM0r5ogCF_BoDg", "Virginia beach", "VA", "Userhasdf4", "Helen", "Assaad");
    static User u4 = new User("4", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRX-xJpJ3K6pzqQcd1iECyMsKuHJw3EoE0qACM6dyezguiZXzCQ", "Irving", "TX", "GetUUi44", "John", "Mark");
    static User u5 = new User("5", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRVwXLOr3wueD-REXOrVQ3PpuE7iNin4hMq49eWmh92-GJhFh3IJA", "Georgia", "AT", "Zb874fn", "Mark", "John");
    static User u6 = new User("6", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTSPswjzSo8aTZPmov8gKlup9_OYxEfM3kVSJ5kqq98NYrHs2N-", "Huston", "TX", "Giiie87f", "Mark", "Antony");
    static User u7 = new User("7", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRX-xJpJ3K6pzqQcd1iECyMsKuHJw3EoE0qACM6dyezguiZXzCQ", "Miami", "FL", "Zela@gmm44", "Mark", "Yohannes");
    static User u8 = new User("8", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQiTVO3MbX4GMDjLkHEMmSs1BRctlclV9xW6wh-qTrLnlClPQsA", "Melbourne", "FL", "User123", "Simone", "Temothy");
    static User u9 = new User("9", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSde6itBpg5nP7A5vagdeJCQmOkoKsBg4_SGrJVGu9kUp1myOyGdg", "NewYork City", "NY", "Zela.bel", "Homier", "Quan");
    static User u10 = new User("10", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT-0VT_2DH-9RiF_5mwIxEKQS8u2VtoWeUI2iUHrM0r5ogCF_BoDg", "Los Angeles", "CA", "User.34", "Mark", "Montegro");
    static User u11 = new User("11", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTSPswjzSo8aTZPmov8gKlup9_OYxEfM3kVSJ5kqq98NYrHs2N-", "Irvine", "CA", "Log.Im", "Mark", "Antony");
    static User u12 = new User("12", "http://www.venmond.com/demo/vendroid/img/avatar/big.jpg", "Palm Bay", "FL", "MC5584", "Mark", "Ben");
    static User u13 = new User("13", "http://www.venmond.com/demo/vendroid/img/avatar/big.jpg", "San Antino", "TX", "ZB86332", "Mark", "Antony");
    static User u14 = new User("14", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSc4KD3G9JX4VMsa5kB0eaJUakSqRpuhdMWTbvlcCRO-hrIUyo0Jg", "Fairfield", "IA", "U86h4j", "Ben", "Afflek");
    static User u15 = new User("15", "http://www.venmond.com/demo/vendroid/img/avatar/big.jpg", "Dallas", "TX", "Mc12343", "Helen", "Ben");

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
        addFriendToUser(u4, u2);

        addFriendToUser(u7, u6);
        addFriendToUser(u8, u7);
        addFriendToUser(u9, u7);
        addFriendToUser(u10, u9);
        addFriendToUser(u10, u8);

        addFriendToUser(u12, u11);
        addFriendToUser(u13, u12);

        addFriendToUser(u15, u14);

        handleMutualConnections();

    }

    private void handleMutualConnections() {
        initialUsersList.stream().forEach(eachUser -> {
            addMutualConnections(eachUser, eachUser);
            eachUser.getMutualConnections().removeAll(eachUser.getFriendList());
            eachUser.setMutualConnections(eachUser.getMutualConnections().stream().distinct().collect(Collectors.toList()));
        });

    }


    public User getUserByUserName(String unm){
        System.out.println("Searching for "+ unm);

        User user = this.initialUsersList
                .stream()
                .filter(u -> u.getUsername().equalsIgnoreCase(unm))
                .findAny()
                .get();


//        user.getMutualConnections().forEach(innerUser -> user
//                .getFriendList()
//                .add(innerUser));

//        user.setFriendList(user.getFriendList().stream().distinct().collect(Collectors.toList()));

        return user;
    }


    public void addMutualConnections(User user, User innerUser){
        for (User u: innerUser.getFriendList()) {
                user.getMutualConnections().add(u);
                addMutualConnections(user, u);
        }
    }
    public List<User> getAllUsers() {
        return initialUsersList;
    }
}
