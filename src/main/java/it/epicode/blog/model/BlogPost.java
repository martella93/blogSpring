package it.epicode.blog.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class BlogPost {

    @Id
    @GeneratedValue
    private int id;
//    private static int cont;
    private String categoria;
    private String titolo;
    private String cover;
    private String contenuto;
    private double tempoDiLettura;

    @ManyToOne
    @JoinColumn(name = "autore_id")
    @JsonIgnore
    private Autore autore;
//    public BlogPost( String categoria, String titolo, String contenuto, double tempoDiLettura) {
//        this.categoria = categoria;
//        this.titolo = titolo;
//        this.cover = "https://picsum.photos/200/300";
//        this.contenuto = contenuto;
//        this.tempoDiLettura = tempoDiLettura;
//        cont++;
//        id=cont;
//    }
}
