package za.ac.cput.service.tertiaryInstitution.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.tertiaryInstitution.Course;
import za.ac.cput.repository.tertiaryInstitution.CourseRepository;
import za.ac.cput.service.tertiaryInstitution.CourseService;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository repository;


    @Override
    public Set<Course> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Set<Course> searchByName(String name) {
        Set<Course> courses = getAll();
        Set<Course> coursesWith = new HashSet<>();
        for (Course course : courses) {
            if (course.getCourseName().trim().toLowerCase().contains(name)) {
                coursesWith.add(course);
            }
        }
        return coursesWith;
    }

    @Override
    public Course create(Course course) {
        return this.repository.save(course);
    }

    @Override
    public Course read(String id) {
        return this.repository.findById(id).orElseGet(null);
    }

    @Override
    public Course update(Course course) {
        //return this.repository.save(course);
        return create(course);

//        if (this.repository.existsById(course.getCourseId())){
//            return this.repository.save(course);
//
//        }
//
//        return  null;
    }

    @Override
    public boolean delete(String id) {
        this.repository.deleteById(id);
       if(this.repository.existsById(id)) return false;
       else return true;
    }
}
