package it.epicode.blog.controller;

import it.epicode.blog.Dto.BlogPostDto;
import it.epicode.blog.model.BlogPost;
import it.epicode.blog.service.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BlogPostController {

    @Autowired
    private BlogPostService blogPostService;

    @PostMapping("/api/blogPost")
    public String saveBlogPost(@RequestBody BlogPostDto blogPostDto){
        return blogPostService.saveBlogPost(blogPostDto);
    }

    @GetMapping("/api/blogPost")
    public Page<BlogPost> getBlogPost( @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                                       @RequestParam(value = "size", required = false, defaultValue = "10") Integer size,
                                       @RequestParam(value = "sortBy", required = false, defaultValue = "id") String sortBy){
        return blogPostService.getBlogPost(page,size,sortBy);
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
    public BlogPost updateBlogPost(@PathVariable int id,@RequestBody BlogPostDto blogPostDto){
        return blogPostService.updateBlogPost(id, blogPostDto);
    }

    @DeleteMapping("/api/blogPost/{id}")
    public String deleteBlogPost(@PathVariable int id){
        return blogPostService.deleteBlogPost(id);
    }

}
