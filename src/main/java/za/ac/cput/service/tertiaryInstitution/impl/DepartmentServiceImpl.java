package za.ac.cput.service.tertiaryInstitution.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.tertiaryInstitution.Department;
import za.ac.cput.repository.tertiaryInstitution.DepartmentRepository;
import za.ac.cput.service.tertiaryInstitution.DepartmentService;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository repository;

    @Override
    public Set<Department> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Set<Department> searchByName(String name) {
        Set<Department> departmentSet = getAll();
        Set<Department> departmentsStartingWith = new HashSet<>();
        for(Department department : departmentSet){
            if(department.getDepartmentName().trim().toLowerCase().contains(name))
            {
                departmentsStartingWith.add(department);
            }
        }
        return departmentsStartingWith;
    }

    @Override
    public Department create(Department department) {
        return this.repository.save(department);
    }

    @Override
    public Department read(String s) {
        return this.repository.findById(s).orElseGet(null);
    }

    @Override
    public Department update(Department department) {
        return create(department);
//        if (this.repository.existsById(department.getDepartmentId())) {
//            return this.repository.save(department);
//        }
//        return null;
    }

    @Override
    public boolean delete(String s) {
        this.repository.deleteById(s);

        if (this.repository.existsById(s)) return false;
        else return true;
    }
}
