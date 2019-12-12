package fr.upem.master2.devops.apprentis.devopsupemws.ressource;

import fr.upem.master2.devops.apprentis.devopsupemws.model.Personne;
import fr.upem.master2.devops.apprentis.devopsupemws.repository.PersonneRepository;
import fr.upem.master2.devops.apprentis.devopsupemws.service.PersonneService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;
import java.util.Optional;
//on empeche d'appel le repository sinon il va ecrire dans la base
//on veut intercépter les requètes
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PersonneRessourceTest {
    @LocalServerPort
    private int port;


    @MockBean
    private PersonneService personneService;
    @MockBean
    private PersonneRepository personneRepository;

    @Autowired
    private TestRestTemplate restTemplate;
    @Test
    public void getAll() throws Exception {

        List<Personne> personnes = this.restTemplate.getForObject("http://localhost:" + port + "/personnes", List.class);

        assertEquals(0, personnes.size());

    }

    @Test
    public void postPersonne() {
        Personne personne=new Personne("nom","prenom");
        personne.setId(1L);
        when(personneRepository.save(personne)).thenReturn(personne);


    }

    @Test
    public void getOne() {
        Personne personne=new Personne("nom","prenom");

        Personne p=this.restTemplate.getForObject("http://localhost:" + port + "/personnes/1", Personne.class);
    }

    @Test
    public void deletePersonne() {
      /*  Personne personne=new Personne("nom","prenom");
        personne.setId(1L);
        when(personneRepository.findById(1L)).thenReturn(Optional.of(personne));
        doNothing().when(personneRepository).delete(personne);

        Personne result = this.restTemplate.exchange("http://localhost:" + port + "/personnes/1",
                HttpMethod.DELETE, null, Personne.class).getBody();

        Assert.assertEquals(personne.getId(),result.getId());
        Assert.assertEquals(personne.getNom(),result.getNom());
        Assert.assertEquals(personne.getPrenom(),result.getPrenom());*/
    }

    @Test
   public void putPersonne() {
        Personne personne=new Personne("nom","prenom");



    }
}