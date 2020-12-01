package za.ac.cput.controller.tertiaryInstitution;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.tertiaryInstitution.Course;
import za.ac.cput.entity.tertiaryInstitution.Faculty;
import za.ac.cput.factory.tertiaryInstitution.FacultyFactory;
import za.ac.cput.service.tertiaryInstitution.impl.FacultyServiceImpl;

import java.util.Set;

@RestController
@RequestMapping("/faculty")
public class FacultyController {

    @Autowired
    private FacultyServiceImpl facultyService;

    @PostMapping("/create")
    public Faculty create(@RequestBody Faculty faculty)
    {
        Faculty newFaculty = FacultyFactory.createFaculty(faculty.getFacultyName(), faculty.getFacultyCode());
        return facultyService.create(newFaculty);

    }

    @GetMapping("/read/{id}")
    public Faculty read(@PathVariable String id ){
        return facultyService.read(id);

    }

    @PostMapping("/update")
    public Faculty update(@RequestBody Faculty faculty){
        return facultyService.update(faculty);

    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){
        return facultyService.delete(id);

    }

    @GetMapping ("/all")
    public Set<Faculty> getAll(){
        return facultyService.getAll();
    }

    @GetMapping("/searchby/{name}")
    public Set<Faculty> searchByName(@PathVariable String name) { return facultyService.searchByName(name); }



}