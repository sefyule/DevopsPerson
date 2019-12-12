package fr.upem.master2.devops.apprentis.devopsupemws.service;

import fr.upem.master2.devops.apprentis.devopsupemws.model.Personne;
import fr.upem.master2.devops.apprentis.devopsupemws.repository.PersonneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonneService {
    @Autowired
    private PersonneRepository personneRepository;

    public Iterable<Personne>getAll(){
        return personneRepository.findAll();
    }

    public Personne createPersonne(Personne personne){

        return personneRepository.save(personne);
    }


    public Optional<Personne> getOne(Long id) {

        return personneRepository.findById(id);
    }

    public void deletePersonne(Long id) {

        personneRepository.deleteById(id);
    }

    public Personne updatePersonne(Long id, Personne personne) {
        personneRepository.findById(id);
        personne.setId(id);
        return personneRepository.save(personne);
    }
}
