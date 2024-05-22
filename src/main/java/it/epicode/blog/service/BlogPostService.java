package it.epicode.blog.service;


import it.epicode.blog.Dto.BlogPostDto;
import it.epicode.blog.exception.AutoreNotFoundException;
import it.epicode.blog.exception.BlogPostNotFoundException;
import it.epicode.blog.model.Autore;
import it.epicode.blog.model.BlogPost;
import it.epicode.blog.repository.AutoreRepository;
import it.epicode.blog.repository.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class BlogPostService {

    @Autowired
    private BlogPostRepository blogPostRepository;

    @Autowired
    private AutoreRepository autoreRepository;

    public String saveBlogPost(BlogPostDto blogPostDto){
        BlogPost blogPost = new BlogPost();
        blogPost.setTitolo(blogPostDto.getTitolo());
        blogPost.setCategoria(blogPostDto.getCategoria());
        blogPost.setTempoDiLettura(blogPostDto.getTempoDiLettura());
        blogPost.setContenuto(blogPostDto.getContenuto());

        Optional<Autore> autoreOptional = autoreRepository.findById(blogPostDto.getAutoreId());

        if (autoreOptional.isPresent()){
            Autore autore = autoreOptional.get();
            blogPost.setAutore(autore);
            blogPostRepository.save(blogPost);
            return "Blog con id " + blogPost.getId() + " salvatto con successo";
        }
        else{
            throw new BlogPostNotFoundException("Blog non trovata");
        }
    }

    public Page<BlogPost> getBlogPost(int page, int size, String sortBy){
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return blogPostRepository.findAll(pageable);
    }

    public Optional<BlogPost> getBlogPostById(int id){
        return blogPostRepository.findById(id);
    }

    public BlogPost updateBlogPost(int id, BlogPostDto blogPostDto){
        Optional<BlogPost> blogPostOptional = getBlogPostById(id);

        if (blogPostOptional.isPresent()){
            BlogPost blogPost = blogPostOptional.get();

            blogPost.setTitolo(blogPostDto.getTitolo());
            blogPost.setCategoria(blogPostDto.getCategoria());
            blogPost.setTempoDiLettura(blogPostDto.getTempoDiLettura());
            blogPost.setContenuto(blogPostDto.getContenuto());

            Optional<Autore> autoreOptional = autoreRepository.findById(blogPostDto.getAutoreId());
            if (autoreOptional.isPresent()){
                Autore autore = autoreOptional.get();
                blogPost.setAutore(autore);
                blogPostRepository.save(blogPost);
                return blogPost;
            }
            else {
                throw new BlogPostNotFoundException("Blog non trovato");
            }
        }
        else {
            throw new AutoreNotFoundException("Autore non trovato");
        }
    }

    public String deleteBlogPost(int id){
        Optional<BlogPost> blogPostOptional = blogPostRepository.findById(id);

        if (blogPostOptional.isPresent()){
            blogPostRepository.delete(blogPostOptional.get());
            return "Blog cancellato con successo";
        }
        else {
            throw new BlogPostNotFoundException("Blog non trovato");
        }
    }


}
