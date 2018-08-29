package com.zjty.sharding;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

import static com.zjty.sharding.DateTimeUtil.parseToDate;

@Slf4j
@SpringBootApplication
public class ShardingJdbcApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ShardingJdbcApplication.class, args);
    }

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        log.info("insert test data....");
        ArrayList<User> users = Lists.newArrayList(
                new User(null, 1, "jack", parseToDate("2018-05-23 00:00:00")),
                new User(null, 2, "rose", parseToDate("2018-06-22 00:00:00")),
                new User(null, 3, "yoda", parseToDate("2018-06-11 00:00:00"))
        );
        userRepository.save(users);

        System.out.println("find id after 0 test");
        for (User user : userRepository.findByIdAfter(0)) {
            System.out.println(user.toString());
        }

        System.out.println("find time after 201804 test");
        for (User user : userRepository.findByTmFetchAfter(parseToDate("2018-04-03"))) {
            System.out.println(user.toString());
        }
    }
}
