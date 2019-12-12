package fr.upem.master2.devops.apprentis.devopsupemws.ressource;

import fr.upem.master2.devops.apprentis.devopsupemws.model.Personne;
import fr.upem.master2.devops.apprentis.devopsupemws.service.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class PersonneRessource {
    @Autowired
    private PersonneService personneService;

    @GetMapping("/personnes")
    public Iterable<Personne> getAll() {
        return personneService.getAll();
    }

    @PostMapping("/personnes")
    public Personne postPersonne(@RequestBody Personne p) {
        return personneService.createPersonne(p);
    }

    @GetMapping("personnes/{id}")
    public Optional<Personne> getOne(@PathVariable Long id) {
        //@PathVariable {id}
        return personneService.getOne(id);
    }

    @DeleteMapping("personnes/{id}")
    public void deletePersonne(@PathVariable Long id) {
        personneService.deletePersonne(id);
    }

    @PostMapping("personnes/{id}")
    public Personne putPersonne(@PathVariable Long id, @RequestBody Personne personne) {
        return personneService.updatePersonne(id, personne);
    }
}
