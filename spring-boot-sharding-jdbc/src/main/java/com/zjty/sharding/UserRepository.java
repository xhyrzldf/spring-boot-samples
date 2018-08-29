package com.zjty.sharding;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

/**
 * springboot-samples.
 *
 * @author : Matrix [xhyrzldf@foxmail.com]
 * @Date : 18-8-29
 */
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByIdAfter(int id);

    List<User> findByTmFetchAfter(Date tmFetch);
}
