package za.ac.cput.service.tertiaryInstitution;

import za.ac.cput.entity.tertiaryInstitution.Faculty;
import za.ac.cput.entity.user.User;
import za.ac.cput.service.IService;

import java.util.Set;

public interface FacultyService extends IService<Faculty, String> {
    Set<Faculty> getAll();

    Set<Faculty> searchByName(String name);
}
