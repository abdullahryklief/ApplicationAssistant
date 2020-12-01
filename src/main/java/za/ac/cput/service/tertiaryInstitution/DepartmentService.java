package za.ac.cput.service.tertiaryInstitution;

import za.ac.cput.entity.tertiaryInstitution.Department;
import za.ac.cput.service.IService;

import java.util.Set;

public interface DepartmentService extends IService<Department, String> {
    Set<Department> getAll();

    Set<Department> searchByName(String name);
}