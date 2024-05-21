package it.epicode.blog.service;

import it.epicode.blog.model.BlogPost;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BlogPostService {

    private List<BlogPost> blogPosts = new ArrayList<>();

    public List<BlogPost> gellAllBlogPost(){
        return blogPosts;
    }

    public Optional<BlogPost> getBlogPostById(int id){
        return blogPosts.stream().filter(blogPost1 -> blogPost1.getId() == id).findFirst();
    }

    public String saveBlogPost(BlogPost blogPost){
        blogPosts.add(blogPost);
        return "BlogPost creato con successo";
    }

    public BlogPost updateBlogPost(int id, BlogPost blogPostUpd){
        Optional<BlogPost> blogPostOpt = getBlogPostById(id);

        if (blogPostOpt.isPresent()){
            BlogPost blogPost = blogPostOpt.get();
            blogPost.setTitolo(blogPostUpd.getTitolo());
            blogPost.setContenuto(blogPostUpd.getContenuto());
            blogPost.setCategoria(blogPostUpd.getCategoria());
            blogPost.setTempoDiLettura(blogPostUpd.getTempoDiLettura());
            return blogPostUpd;
        }
        else {
            return null;
        }
    }

    public String deleteBlogPost(int id) {
        Optional<BlogPost> blogPostOpt = getBlogPostById(id);
        if (blogPostOpt.isPresent()) {
            blogPosts.remove(blogPostOpt.get());
            return "BlogPost cancellato";
        } else {
            return null;
        }
    }
}
