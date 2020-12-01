package za.ac.cput.controller.tertiaryInstitution;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.tertiaryInstitution.Department;
import za.ac.cput.factory.tertiaryInstitution.DepartmentFactory;
import za.ac.cput.service.tertiaryInstitution.impl.DepartmentServiceImpl;

import java.util.Set;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentServiceImpl departmentService;

    @PostMapping("/create")
    public Department create(@RequestBody Department department)
    {
        department = DepartmentFactory.createDepartment(department.getDepartmentName(), department.getDepartmentCode());
        return departmentService.create(department);
    }

    @GetMapping("/all")
    public Set<Department> getAll()
    {
        return departmentService.getAll();
    }

    @GetMapping("/read/{departmentid}")
    public Department read(@PathVariable String departmentId)
    {
        return departmentService.read(departmentId);
    }

    @PostMapping("/update")
    public Department update(@RequestBody Department department)
    {
        return departmentService.update(department);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id)
    {
        return departmentService.delete(id);
    }

    @GetMapping("/searchby/{name}")
    public Set<Department> searchByName(@PathVariable String name) { return departmentService.searchByName(name); }

}
