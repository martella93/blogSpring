package it.epicode.blog.model;

import lombok.Data;

@Data
public class BlogPost {

    private int id;
    private static int cont;
    private String categoria;
    private String titolo;
    private String cover;
    private String contenuto;
    private double tempoDiLettura;

    public BlogPost( String categoria, String titolo, String contenuto, double tempoDiLettura) {
        this.categoria = categoria;
        this.titolo = titolo;
        this.cover = "https://picsum.photos/200/300";
        this.contenuto = contenuto;
        this.tempoDiLettura = tempoDiLettura;
        cont++;
        id=cont;
    }
}
