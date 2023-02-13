package com.example.springboothw27.service;

import com.example.springboothw27.headling.ApiException;
import com.example.springboothw27.model.Blog;
import com.example.springboothw27.model.MyUser;
import com.example.springboothw27.repstiotry.BlogRepsitory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService {
    private final BlogRepsitory blogRepsitory;
    public List blogList(MyUser user){
       /* List blogs=blogRepsitory.findAllByUser(user);
        if(blogs.isEmpty()){
            throw new ApiException("The blogs is empty");
        }
        return blogs;*/
        List blogs=blogRepsitory.getMyBlogs(user.getId());
        if(blogs.isEmpty()){
            throw new ApiException("The blogs is empty");
        }
        return blogs;
    }

    public void addBlog(MyUser user,Blog blog){
        blog.setUser(user);
        blogRepsitory.save(blog);

    }

    public Boolean update(Integer blogId,MyUser user,Blog blog){
        Blog b=blogRepsitory.findBlogById(blogId);
        if(b==null||b.getUser().getId()!=user.getId()){
            return false;
        }
        blog.setUser(user);
        blog.setId(b.getId());
        blogRepsitory.save(blog);
        return true;
    }

    public Boolean delete(Integer blogId,MyUser user){
        Blog b=blogRepsitory.findBlogById(blogId);
        if(b==null||b.getUser().getId()!=user.getId()){
            return false;
        }

        blogRepsitory.delete(b);
        return true;
    }

    public Blog getBlog(Integer id){
        Blog blog=blogRepsitory.findBlogById(id);
        if(blog==null){
            throw new ApiException("the Id is not correct");
        }
        return blog;
    }

    public Blog getBlogByTitle(String title){
        Blog blog=blogRepsitory.findByTitle(title);
        if(blog==null){
            throw new ApiException("the Id is not correct");
        }
        return blog;
    }
}
