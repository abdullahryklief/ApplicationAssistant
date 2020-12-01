package za.ac.cput.entity.tertiaryInstitution;

import java.io.Serializable;
import java.util.Objects;

public class FacultyDepartmentId implements Serializable {
    private String facultyId, departmentId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FacultyDepartmentId that = (FacultyDepartmentId) o;
        return facultyId.equals(that.facultyId) &&
                departmentId.equals(that.departmentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(facultyId, departmentId);
    }
}
