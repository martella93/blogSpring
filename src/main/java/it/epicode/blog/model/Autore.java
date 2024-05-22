package it.epicode.blog.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class Autore {

    @Id
    @GeneratedValue
    private int id;
//    private static int cont;
    private String nome;
    private String cognome;
    private String email;
    private LocalDate dataDiNascita;
    private String avatar;

    @OneToMany(mappedBy = "autore")
    private List<BlogPost> blogPostList;

//    public Autore( String nome, String cognome, String email, LocalDate dataDiNascita, String avatar) {
//        this.nome = nome;
//        this.cognome = cognome;
//        this.email = email;
//        this.dataDiNascita = dataDiNascita;
//        this.avatar = avatar;
//        cont++;
//        id=cont;
//    }
}
