package za.ac.cput.controller.previousQualification;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import za.ac.cput.entity.previousQualification.Qualification;
import za.ac.cput.factory.previousQualification.QualificationFactory;


import static org.junit.Assert.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class QualificationControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/qualification/";
    private static String SECURITY_USERNAME = "Abdullah";
    private static String SECURITY_PASSWORD = "password";

    private static Qualification qualification = QualificationFactory.createQualification("Grade 12");

    @Test
    public void a_create() {
        String url = baseURL + "create";
        System.out.println("URL: " + url);
        System.out.println("Post Data: " + qualification);

        ResponseEntity<Qualification> postResponse = restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .postForEntity(url, qualification, Qualification.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        System.out.println(postResponse);

        qualification = postResponse.getBody();
        System.out.println("Saved Data: " + qualification);
        assertEquals(HttpStatus.OK, postResponse.getStatusCode());
        assertEquals(qualification.getQualificationId(), postResponse.getBody().getQualificationId());
    }

    @Test
    public void d_getAll() {
        String url = baseURL + "all";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println(response);
    }

    @Test
    public void b_read() {
        String url = baseURL + "read/" + qualification.getQualificationId();
        System.out.println("URL: " + url);

        ResponseEntity<Qualification> response = restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .getForEntity(url, Qualification.class);
        assertEquals(qualification.getQualificationId(), response.getBody().getQualificationId());
        System.out.println(response.getBody());
    }

    @Test
    public void c_update() {
        //Subject subject = SubjectFactory.createSubject("Math", 80);
        //Set<Subject> subjectList = new HashSet<>();
        //subjectList.add(subject);
        Qualification updated = new Qualification.Builder().copy(qualification).setLevelOfQualifications("Grade 11").build();
        String url = baseURL + "update";
        System.out.println("URL: " + url);
        System.out.println("Post Data: " + updated);
        ResponseEntity<Qualification> postResponse = restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .postForEntity(url, updated, Qualification.class);
        assertEquals(qualification.getQualificationId(), postResponse.getBody().getQualificationId());
    }

    @Test
    public void f_delete() {
        String url = baseURL + "delete/" + qualification.getQualificationId();
        System.out.println("URL: " + url);
        restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .delete(url);    }

    @Test
    public void e_getAllStartingWith() {
        String url = baseURL + "allwith/" + "g";
        System.out.println("URL: " + url);

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println(response);
    }
}