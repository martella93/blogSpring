package it.epicode.blog.service;


import it.epicode.blog.Dto.AutoreDto;
import it.epicode.blog.exception.AutoreNotFoundException;
import it.epicode.blog.model.Autore;
import it.epicode.blog.repository.AutoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutoreService {

    @Autowired
    private AutoreRepository autoreRepository;

    public String saveAutore(AutoreDto autoreDto){
        Autore autore = new Autore();

        autore.setNome(autoreDto.getNome());
        autore.setCognome(autoreDto.getCognome());
        autore.setEmail(autoreDto.getEmail());
        autore.setDataDiNascita(autoreDto.getDataDiNascita());

        autoreRepository.save(autore);
        return "Autore con id: " + autore.getId() + " creato con successo";

    }

    public List<Autore> getAutori(){
        return autoreRepository.findAll();
    }

    public Optional<Autore> getAutoreById(int id){
        return autoreRepository.findById(id);
    }

    public Autore updateAutore(int id, AutoreDto autoreDto){
        Optional<Autore> autoreOptional = getAutoreById(id);

        if (autoreOptional.isPresent()){
            Autore autore = autoreOptional.get();
            autore.setNome(autoreDto.getNome());
            autore.setCognome(autoreDto.getCognome());
            autore.setEmail(autoreDto.getEmail());
            autore.setDataDiNascita(autoreDto.getDataDiNascita());
            return autoreRepository.save(autore);
        }
        else {
            throw new AutoreNotFoundException("Autore non trovato");
        }
    }

    public String deleteAutore(int id){
        Optional<Autore> autoreOptional = getAutoreById(id);
        if (autoreOptional.isPresent()){
            autoreRepository.delete(autoreOptional.get());
            return "Auotore con id " + id + " cancellato";
        }
        else {
            throw new AutoreNotFoundException("autore non trovato");
        }
    }
}
