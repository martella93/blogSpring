package it.epicode.blog.controller;

import it.epicode.blog.model.Autore;
import it.epicode.blog.service.AutoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AutoreController {

    @Autowired
    private AutoreService autoreService;

    @PostMapping("/api/autore")
    public String saveAutore(@RequestBody Autore autore){
        return autoreService.saveAutore(autore);
    }

    @GetMapping("/api/autore")
    public List<Autore> getAllAutori(){
        return autoreService.getAllAutori();
    }

    @GetMapping("/api/autore/{id}")
    public Autore getAutoreById(@PathVariable int id){
        Optional<Autore> autoreOpt = autoreService.getAutoreById(id);

        if (autoreOpt.isPresent()){
            return autoreOpt.get();
        }
        else {
            return null;
        }
    }

    @PutMapping("/api/autore/{id}")
    public Autore updateAutore(@PathVariable int id,@RequestBody Autore autore){
        return autoreService.updateAutore(id, autore);
    }

    @DeleteMapping("/api/autore/{id}")
    public String deleteAutore(@PathVariable int id){
        return autoreService.deleteAutore(id);
    }
}
