package it.epicode.blog.model;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;

@Data
public class Error {
    private String message;
    private LocalDate dataErrore;
    private HttpStatus statoerrore;
}
