package com.jfam.mobility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Zeelo on 2/10/2019.
 */
@RestController
public class SocialAppController
{
    UsersWareHouseService usersWareHouseService = new UsersWareHouseService();

    @Autowired
    MyRepository myRepository;

    @Autowired
    UserRepository userRepository;

   @RequestMapping(value = "/api/users/getUser/{userName}", method= RequestMethod.GET)
    public @ResponseBody
   User getUsersList(@PathVariable("userName") String userName){

       User user = usersWareHouseService.getUserByUserName(userName);

       return user;
    }
    @RequestMapping(value = "/api/users/getAllUsers", method= RequestMethod.GET)
    public @ResponseBody List<User> getAllUsers(){
        return usersWareHouseService.getAllUsers();
    }

    @RequestMapping(value = "/testJpa/{name}", method= RequestMethod.GET)
    public @ResponseBody List<Person> TestJPA(@PathVariable String name){
        myRepository.save(new Person(name));
        System.out.println(myRepository.count());
        UsersWareHouseService.initialUsersList.stream().distinct().collect(Collectors.toList()).forEach(userRepository::save);
        List<Person> personList = new ArrayList<>();
        myRepository.findAll().forEach(personList::add);
        return personList;
    }
}
