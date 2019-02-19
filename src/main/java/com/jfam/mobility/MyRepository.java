package com.jfam.mobility;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Zeelo on 2/18/2019.
 */

@Repository
public interface MyRepository extends CrudRepository<Person, Integer>{
}
