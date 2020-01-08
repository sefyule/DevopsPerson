package fr.upem.master2.devops.apprentis.devopsupemws.repository;

import fr.upem.master2.devops.apprentis.devopsupemws.model.Personne;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public interface PersonneRepository extends CrudRepository<Personne,Long> {

}
