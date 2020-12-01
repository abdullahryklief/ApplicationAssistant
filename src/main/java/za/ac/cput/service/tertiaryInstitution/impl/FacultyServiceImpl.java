package za.ac.cput.service.tertiaryInstitution.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.tertiaryInstitution.Faculty;
import za.ac.cput.repository.tertiaryInstitution.FacultyRepository;
import za.ac.cput.service.tertiaryInstitution.FacultyService;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class FacultyServiceImpl implements FacultyService {
    @Autowired
    private FacultyRepository repository;

    @Override
    public Set<Faculty> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Set<Faculty> searchByName(String name) {
        Set<Faculty> facultySet = getAll();
        Set<Faculty> facultiesWith = new HashSet<>();
        for(Faculty faculty : facultySet)
        {
            if(faculty.getFacultyName().trim().toLowerCase().contains(name)){
                facultiesWith.add(faculty);
            }
        }
        return facultiesWith;
    }

    @Override
    public Faculty create(Faculty faculty) {
        return this.repository.save(faculty);
    }

    @Override
    public Faculty read(String FacultyId) {
        return this.repository.findById(FacultyId).orElseGet(null);
    }

    @Override
    public Faculty update(Faculty faculty) {
        return this.repository.save(faculty);
    }

    @Override
    public boolean delete(String FacultyId) {
        this.repository.deleteById(FacultyId);
        if (this.repository.existsById(FacultyId)) return false;
        else return true;
    }
}
