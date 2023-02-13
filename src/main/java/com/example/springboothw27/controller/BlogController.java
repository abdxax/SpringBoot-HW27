package com.example.springboothw27.controller;

import com.example.springboothw27.model.Blog;
import com.example.springboothw27.model.MyUser;
import com.example.springboothw27.service.BlogService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/blog")
@RequiredArgsConstructor
public class BlogController {
    private final BlogService blogService;
@GetMapping("/getAll")
    public List<Blog> getAll(@AuthenticationPrincipal MyUser user){
        return blogService.blogList(user);
    }
    @PostMapping("/addBlog")
    public ResponseEntity addBlog(@AuthenticationPrincipal MyUser user, @RequestBody @Valid Blog blog){
        blogService.addBlog(user,blog);
        return ResponseEntity.status(HttpStatus.OK).body("Added done");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateBlog(@AuthenticationPrincipal MyUser user, @PathVariable Integer id,@RequestBody @Valid Blog blog){
        Boolean res=blogService.update(id,user,blog);
        if(!res){
            return ResponseEntity.status(400).body("The id is not found ");
        }
        return ResponseEntity.status(200).body("Update done");
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity deleteBlog(@AuthenticationPrincipal MyUser user, @PathVariable Integer id){
        Boolean res=blogService.delete(id,user);
        if(!res){
            return ResponseEntity.status(400).body("The id is not found ");
        }
        return ResponseEntity.status(200).body("delete done");
    }
    @GetMapping("/getBlog/{id}")
    public ResponseEntity getBlog(@PathVariable Integer id){
    Blog blog=blogService.getBlog(id);
    return ResponseEntity.status(200).body(blog);
    }

    @GetMapping("/getBlogByTitle/{title}")
    public ResponseEntity getBlog(@PathVariable String title){
        Blog blog=blogService.getBlogByTitle(title);
        return ResponseEntity.status(200).body(blog);
    }




}
