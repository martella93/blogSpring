package it.epicode.blog.Dto;

import lombok.Data;

@Data
public class BlogPostDto {

    private String categoria;
    private String titolo;
    private String contenuto;
    private double tempoDiLettura;

    private int autoreId;
}
