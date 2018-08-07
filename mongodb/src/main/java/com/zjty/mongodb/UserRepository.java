package com.zjty.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * springboot-samples.
 *
 * @author : Matrix [xhyrzldf@foxmail.com]
 * @Date : 18-8-6
 */
public interface UserRepository extends MongoRepository<User,Long> {

    User findByUsername(String username);
}
