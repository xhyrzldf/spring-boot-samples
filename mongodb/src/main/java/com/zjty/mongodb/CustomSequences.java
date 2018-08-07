package com.zjty.mongodb;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * springboot-samples.
 *
 * @author : Matrix [xhyrzldf@foxmail.com]
 * @Date : 18-8-6
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "customSequences")
public class CustomSequences {
    @Id
    private String id;
    private Long seq;

}
