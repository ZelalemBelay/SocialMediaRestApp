package com.jfam.mobility;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Zeelo on 2/10/2019.
 */
@Controller
public class SocialAppController
{
    UsersWareHouseService usersWareHouseService = new UsersWareHouseService();

   @RequestMapping(value = "getFriendsList/{userName}", method= RequestMethod.GET)
    public @ResponseBody List<User> getUsersList(@PathVariable("userName") String userName){

       User user = usersWareHouseService.getUserByUserName(userName);

       return user.getFriendList();
    }
    @RequestMapping(value = "getAllUsers}", method= RequestMethod.GET)
    public @ResponseBody List<User> getAllUsers(){
        return usersWareHouseService.getAllUsers();
    }

}
