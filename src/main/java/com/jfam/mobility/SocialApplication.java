package com.jfam.mobility;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.jfam")
public class SocialApplication {

	public static void main(String[] args) {
     	SpringApplication.run(SocialApplication.class, args);

		UsersWareHouseService service = new UsersWareHouseService();
		service.populateUsers();
		UsersWareHouseService.u1.getFriendList();

		System.out.println("RUN");
	}
}

