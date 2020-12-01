package za.ac.cput.controller.previousQualification;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.financialAid.Funding;
import za.ac.cput.entity.previousQualification.Subject;
import za.ac.cput.factory.previousQualification.SubjectFactory;
import za.ac.cput.service.previousQualification.SubjectService;
import za.ac.cput.service.previousQualification.impl.SubjectServiceImpl;

import java.util.Set;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    private SubjectServiceImpl subjectService;


    @PostMapping("/create")
    public Subject create(@RequestBody Subject subject){
        Subject newSubject = SubjectFactory.createSubject(subject.getSubjectName(), subject.getSubjectMark());

        return subjectService.create(newSubject);

    }

    @GetMapping("/all")
    public Set<Subject> getAll(){
        return subjectService.getAll();
    }

    @GetMapping("/read/{subjectid}")
    public Subject read(@PathVariable String subjectid) { return subjectService.read(subjectid);}

    @PostMapping("/update")
    public Subject update(@RequestBody Subject subject) {
        return subjectService.update(subject);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id) {
        return subjectService.delete(id);
    }

    @GetMapping("/searchby/{name}")
    public Set<Subject> searchByName(@PathVariable String name)
    {
        return subjectService.searchByName(name);
    }

}
