package com.zjty.sharding;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * springboot-samples.
 *
 * @author : Matrix [xhyrzldf@foxmail.com]
 * @Date : 18-8-29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue
    private Long primaryId;

    private Integer id;

    private String name;

    private Date tmFetch;
}
