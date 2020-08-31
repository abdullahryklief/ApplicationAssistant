package za.ac.cput.repository.tertiaryInstitution.impl;

import org.junit.*;
import org.junit.runners.MethodSorters;
import za.ac.cput.entity.tertiaryInstitution.Course;
import za.ac.cput.factory.tertiaryInstitution.CourseFactory;
import za.ac.cput.repository.tertiaryInstitution.CourseRepository;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CourseRepositoryImplTest {

    private static CourseRepository repository = CourseRepositoryImpl.getRepository();
    private static Course course = CourseFactory.createCourse("ICT: Multimedia", "ICT256S");

    @Test
    public void d_getAll()
    {
        System.out.println("Get All: " + repository.getAll());
    }

    @Test
    public void a_create()
    {
        Course created = repository.create(course);
        Assert.assertEquals(course.getCourseName(), created.getCourseName());
        Assert.assertEquals(course.getCourseCode(), created.getCourseCode());
        System.out.println("Created: " + created);
    }

    @Test
    public void b_read()
    {
        Course read = repository.read(course.getCourseName());
        System.out.println("Read: " + read);
    }

    @Test
    public void c_update()
    {
        Course updated = new Course.Builder().copy(course).setCourseName("NewCourseName").build();
        updated = repository.update(updated);
        System.out.println("Updated: " + updated);
    }

    @Test
    public void e_delete()
    {
        boolean deleted = repository.delete(course.getCourseName());
        Assert.assertTrue(deleted);
    }
}
