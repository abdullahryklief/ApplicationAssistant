package za.ac.cput.service.tertiaryInstitution.impl;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import za.ac.cput.entity.tertiaryInstitution.Faculty;
import za.ac.cput.entity.user.User;
import za.ac.cput.factory.tertiaryInstitution.FacultyFactory;
import za.ac.cput.factory.user.UserFactory;
import za.ac.cput.service.tertiaryInstitution.FacultyService;
import za.ac.cput.service.user.UserService;
import za.ac.cput.service.user.impl.UserServiceImpl;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FacultyServiceImplTest {

    private static FacultyService service = FacultyServiceImpl.getService();
    private static Faculty faculty = FacultyFactory.createFaculty("ICT123", "Information Technology", "Pass mark 60%");

    @Test
    public void d_getAll() {
        Set<Faculty> faculties = service.getAll();
        Assert.assertEquals(1, faculties.size());
        System.out.println("Get All: " + faculties);
    }

    @Test
    public void e_getAllStartingWith() {
        Set<Faculty> faculties = service.getAllStartingWith("i");
        Assert.assertEquals(1, faculties.size());
        System.out.println("Get All Starting With 'A': " + faculties);
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