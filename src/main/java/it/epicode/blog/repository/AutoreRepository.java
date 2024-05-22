package it.epicode.blog.repository;

import it.epicode.blog.model.Autore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutoreRepository extends JpaRepository<Autore, Integer> {
}
