package za.ac.cput.service.tertiaryInstitution.impl;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.entity.tertiaryInstitution.Department;
import za.ac.cput.factory.tertiaryInstitution.DepartmentFactory;
import za.ac.cput.service.tertiaryInstitution.DepartmentService;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DepartmentServiceImplTest {

    @Autowired
    private DepartmentService service;
    private  static Department department = DepartmentFactory.createDepartment("Information Technology", "IT3");



    @Test
    public void d_getAll() {
        Set<Department> departments = service.getAll();
        Assert.assertEquals(1, departments.size());
        System.out.println("All Departments: " +departments);
    }

    @Test
    public void e_searchByName() {
        Set<Department> departments = service.searchByName("Information Technology");
        Assert.assertEquals(1, departments.size());
        System.out.println("All departments by name: " + departments);
    }

    @Test
    public void a_create() {
        Department created = service.create(department);
        Assert.assertEquals(department.getDepartmentName(), created.getDepartmentName());
        Assert.assertEquals(department.getDepartmentCode(), created.getDepartmentCode());
        System.out.println("Created: " + created);
    }

    @Test
    public void b_read() {
        Department read = service.read(department.getDepartmentId());
        System.out.println("Read: " + read);
    }

    @Test
    public void c_update() {
        Department updated = new Department.Builder().copy(department).setDepartmentName("I.T").build();
        updated = service.update(updated);
        System.out.println("Updated: " + updated);
    }

    @Test
    public void f_delete() {
        boolean deleted = service.delete(department.getDepartmentId());
        Assert.assertTrue(deleted);
    }
}

