package fr.upem.master2.devops.apprentis.devopsupemws.repository;

import fr.upem.master2.devops.apprentis.devopsupemws.model.Personne;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public interface PersonneRepository extends CrudRepository<Personne,Long> {


    /*Map<Long,Personne>personneMap=new HashMap<>();
    private Long ids=0L;

    public Iterable<Personne>getAll(){
        return personneMap.values();
    }

    public Personne save(Personne personne) {
        personne.setId(ids++);
        personneMap.put(personne.getId(),personne);
        return personne;
    }

   public Personne getOne(Long id) {
      return personneMap.get(id);
    }

    public void delete(Long id) {
        personneMap.remove(id);
    }

    public Personne update(Long id,Personne personne) {
        Long p=personne.getId();
        if(p==null) throw new IllegalArgumentException("id:" + id +"not found");

        personne.setId(id);
        personneMap.put(personne.getId(),personne);
        return personne;


    }*/
}
