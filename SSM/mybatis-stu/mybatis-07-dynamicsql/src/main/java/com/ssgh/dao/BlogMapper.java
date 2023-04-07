package com.ssgh.dao;

import com.ssgh.pojo.Blog;

import java.util.HashMap;
import java.util.List;

public interface BlogMapper {
    List<Blog> queryBlogIF(HashMap<String, Object> map);
    List<Blog> queryBlogWhere(HashMap<String, Object> map);
    int updateBlog(HashMap<String, Object> map);
    List<Blog> queryBlogChose(HashMap<String, Object> map);
}
