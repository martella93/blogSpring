package it.epicode.blog.controller;

import it.epicode.blog.model.BlogPost;
import it.epicode.blog.service.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BlogPostController {

    @Autowired
    private BlogPostService blogPostService;

    @PostMapping("/api/blogPost")
    public String saveBlogPost(@RequestBody BlogPost blogPost){
        return blogPostService.saveBlogPost(blogPost);
    }

    @GetMapping("/api/blogPost")
    public List<BlogPost> getAllBlogPost(){
        return blogPostService.gellAllBlogPost();
    }

    @GetMapping("/api/blogPost/{id}")
    public BlogPost getBlogPostById(@PathVariable int id){
        Optional<BlogPost> blogPostOpt = blogPostService.getBlogPostById(id);

        if (blogPostOpt.isPresent()){
            return blogPostOpt.get();
        }
        else {
            return null;
        }
    }

    @PutMapping("/api/blogPost/{id}")
    public BlogPost updateBlogPost(@PathVariable int id,@RequestBody BlogPost blogPost){
        return blogPostService.updateBlogPost(id, blogPost);
    }

    @DeleteMapping("/api/blogPost/{id}")
    public String deleteBlogPost(@PathVariable int id){
        return blogPostService.deleteBlogPost(id);
    }

}
