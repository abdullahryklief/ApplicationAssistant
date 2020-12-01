package za.ac.cput.entity.tertiaryInstitution;

import java.io.Serializable;
import java.util.Objects;

public class DepartmentCourseId implements Serializable {
    private String departmentId, courseId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DepartmentCourseId that = (DepartmentCourseId) o;
        return departmentId.equals(that.departmentId) &&
                courseId.equals(that.courseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departmentId, courseId);
    }
}
