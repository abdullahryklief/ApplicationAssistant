package za.ac.cput.controller.tertiaryInstitution;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import za.ac.cput.entity.tertiaryInstitution.Institution;
import za.ac.cput.factory.tertiaryInstitution.InstitutionFactory;

import static org.junit.Assert.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class InstitutionControllerTest {

    private static Institution institution = InstitutionFactory.createInstitution("Cape Peninsula University of Technology", "CPUT");
    private static String SECURITY_USERNAME = "Abdullah";
    private static String SECURITY_PASSWORD = "password";

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/institution/";

    @Test
    public void a_create() {
        String url = baseURL + "create";
        System.out.println("URL: " + url);
        System.out.println("Post data: "+ institution);

        ResponseEntity<Institution> postResponse = restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .postForEntity(url, institution, Institution.class);

        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        System.out.println(postResponse);
        institution = postResponse.getBody();
        System.out.println("Saved data: " + institution);
        assertEquals(HttpStatus.OK, postResponse.getStatusCode());
        assertEquals(institution.getInstitutionId(), postResponse.getBody().getInstitutionId());
    }

    @Test
    public void e_getAllStartingWith() {
        String url = baseURL + "allwith/" + "c";
        System.out.println("URL: " + url);

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .exchange(url, HttpMethod.GET, entity, String.class);

        System.out.println(response);
        System.out.println(response.getBody());
    }

    @Test
    public void b_read() {
        String url = baseURL + "read/" + institution.getInstitutionId();
        System.out.println("URL: " + url);

        ResponseEntity<Institution> response = restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .getForEntity(url, Institution.class);

        System.out.println("Saved data: " + response.getBody());
        assertEquals(institution.getInstitutionId(), response.getBody().getInstitutionId());
    }

    @Test
    public void c_update() {
        Institution updated = new Institution.Builder().copy(institution).setInstitutionCode("CPUT6").build();
        String url = baseURL + "update";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + updated);
        ResponseEntity<Institution> response = restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .postForEntity(url, updated, Institution.class);

        assertEquals(institution.getInstitutionId(), response.getBody().getInstitutionId());
    }

    @Test
    public void d_getAll() {
        String url = baseURL + "all";
        System.out.println("URL: " + url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .exchange(url, HttpMethod.GET, entity, String.class);

        System.out.println(response);
        System.out.println(response.getBody());
    }

    @Test
    public void f_delete() {
        String url = baseURL + "delete/" + institution.getInstitutionId();
        System.out.println("URL: " + url);
        restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .delete(url);
    }
}