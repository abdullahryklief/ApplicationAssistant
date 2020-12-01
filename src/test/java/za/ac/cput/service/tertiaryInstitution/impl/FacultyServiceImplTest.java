package za.ac.cput.service.tertiaryInstitution.impl;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.entity.tertiaryInstitution.Faculty;
import za.ac.cput.factory.tertiaryInstitution.FacultyFactory;
import za.ac.cput.service.tertiaryInstitution.FacultyService;


import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FacultyServiceImplTest {

    @Autowired
    private FacultyService service;
    private static Faculty faculty = FacultyFactory.createFaculty("ICT123", "Information Technology");

    @Test
    public void d_getAll() {
        Set<Faculty> faculties = service.getAll();
        Assert.assertEquals(1, faculties.size());
        System.out.println("Get All: " + faculties);
    }

    @Test
    public void e_searchByName() {
        Set<Faculty> faculties = service.searchByName("ICT123");
        Assert.assertEquals(1, faculties.size());
        System.out.println("All faculties by name: " + faculties);
    }

    @Test
    public void a_create() {
        Faculty created = service.create(faculty);
        Assert.assertEquals(faculty.getFacultyId(),created.getFacultyId());
        System.out.println("Created: " + created);
    }

    @Test
    public void b_read() {
        Faculty read = service.read(faculty.getFacultyId());
        System.out.println("Read: " + read);
    }

    @Test
    public void c_update() {
        Faculty updated = new Faculty.Builder().copy(faculty).setFacultyName("Information Computer Technology").build();
        updated = service.update(updated);
        System.out.println("Updated: " + updated);
    }

    @Test
    public void f_delete() {
        boolean deleted = service.delete(faculty.getFacultyId());
        Assert.assertTrue(deleted);
    }
}