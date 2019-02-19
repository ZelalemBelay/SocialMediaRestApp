package com.jfam.mobility;

import com.jfam.mobility.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Zeelo on 2/18/2019.
 */

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
}
