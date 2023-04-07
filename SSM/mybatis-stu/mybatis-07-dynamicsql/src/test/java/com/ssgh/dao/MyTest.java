package com.ssgh.dao;

import com.ssgh.pojo.Blog;
import com.ssgh.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class MyTest {
    @Test
    public void test01() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", 1);
        map.put("title", "i love you11");
        map.put("author", "ssgh11");
        map.put("views", 23);
        List<Blog> blogs = mapper.queryBlogIF(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        System.out.println("================");
        List<Blog> blogs1 = mapper.queryBlogIF(map);
        for (Blog blog : blogs1) {
            System.out.println(blog);
        }
        sqlSession.close();
    }
    @Test
    public void test02() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", 1);
        map.put("title", "i love you");
        map.put("author", "ssgh");
        map.put("views", 23);
        List<Blog> blogs = mapper.queryBlogWhere(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        sqlSession.close();
    }
    @Test
    public void test03() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", 1);
        map.put("title", "i love you11");
        map.put("author", "ssgh11");
        int n = mapper.updateBlog(map);
        if (n > 0) {
            System.out.println(n + " update success");
            sqlSession.commit();
        }

        sqlSession.close();
    }
    @Test
    public void test04() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", 1);
//        map.put("title", "i love you1");
        map.put("author", "ssgh11");
        List<Blog> blogs = mapper.queryBlogChose(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        sqlSession.close();
    }
}
