package it.epicode.blog.exception;

public class BlogPostNotFoundException extends RuntimeException{

    public BlogPostNotFoundException(String message){
        super(message);
    }
}
