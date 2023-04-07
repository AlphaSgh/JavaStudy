package com.ssgh.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Alias("blog")
public class Blog {
    private int id;
    private String title;
    private String author;
    private Date create_time;
    private int views;

}
