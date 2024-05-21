package it.epicode.blog.service;

import it.epicode.blog.model.Autore;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AutoreService {

    private List<Autore> autori = new ArrayList<>();

    public List<Autore> getAllAutori(){
        return autori;
    }

    public Optional<Autore> getAutoreById(int id){
        return autori.stream().filter(autore -> autore.getId()==id).findFirst();
    }

    public String saveAutore(Autore autore){
        String avatarUrl = "https://ui-avatars.com/api/?name=" + autore.getNome() + "+" + autore.getCognome();
        autore.setAvatar(avatarUrl);
        autori.add(autore);
        return "Autore salvato con successo!";
    }

    public Autore updateAutore(int id, Autore autoreUpd){
        Optional<Autore> autoreOpt = getAutoreById(id);
        if (autoreOpt.isPresent()){
            Autore autore = autoreOpt.get();
            autore.setNome(autoreUpd.getNome());
            autore.setCognome(autoreUpd.getCognome());
            autore.setEmail(autoreUpd.getEmail());
            autore.setDataDiNascita(autoreUpd.getDataDiNascita());
            autore.setAvatar("https://ui-avatar.com/api/?name=" + autore.getNome());
            return autoreUpd;
        }
        else {
            return null;
        }
    }
     public String deleteAutore(int id){
        Optional<Autore> autoreOpt = getAutoreById(id);
        if (autoreOpt.isPresent()){
            autori.remove(autoreOpt.get());
            return "Autore cancellato";
        }
        else {
            return null;
        }
     }
}
