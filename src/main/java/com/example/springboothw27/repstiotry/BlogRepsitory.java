package com.example.springboothw27.repstiotry;

import com.example.springboothw27.model.Blog;
import com.example.springboothw27.model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepsitory extends JpaRepository<Blog,Integer> {
    //List<Blog>
    Blog findBlogById(Integer id);
    //List<Blog> findBlogByUser(MyUser user);
        //List<Blog> findAllByUser(MyUser user);
    @Query("select  b from  Blog  b where b.user.id=?1")
    List<Blog> getMyBlogs(Integer id);


    Blog findByTitle(String title);
}
