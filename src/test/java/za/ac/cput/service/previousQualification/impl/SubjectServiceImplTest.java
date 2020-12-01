package za.ac.cput.service.previousQualification.impl;

import org.junit.*;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.entity.previousQualification.Subject;
import za.ac.cput.factory.previousQualification.SubjectFactory;
import za.ac.cput.service.previousQualification.SubjectService;

import java.util.*;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SubjectServiceImplTest {

    @Autowired
    private SubjectService service;
    private static Subject subject = SubjectFactory.createSubject("App Development", 84);

    @Test
    public void d_getAll() {
        Set<Subject> subjects = service.getAll();
        Assert.assertEquals(1, subjects.size());
        System.out.println("All subjects: " + subjects);
    }

    @Test
    public void e_searchByName(){
        Set<Subject> subjects = service.searchByName("App Dev");
        Assert.assertEquals(1, subjects.size());
        System.out.println("Gets everything sorted by name: " + subjects);
    }

    @Test
    public void a_create() {

        Subject created = service.create(subject);
        Assert.assertEquals(subject.getSubjectName(), created.getSubjectName());
        Assert.assertEquals(subject.getSubjectMark(), created.getSubjectMark());
        System.out.println("Created:"+ created);
    }

    @Test
    public void b_read() {
        Subject read =  service.read(subject.getSubjectId());
        System.out.println("Read:"+ read);
    }

    @Test
    public void c_update() {

        Subject updated = new Subject.Builder().copy(subject).setSubjectName("Multimedia").build();
        updated = service.update(updated);
        System.out.println("Updated:" + updated);
    }

    @Test
    public void f_delete() {

        boolean deleted = service.delete(subject.getSubjectId());
        Assert.assertTrue(deleted);
    }
}