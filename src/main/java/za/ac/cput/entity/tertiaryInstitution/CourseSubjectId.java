package za.ac.cput.entity.tertiaryInstitution;

import java.io.Serializable;
import java.util.Objects;

public class CourseSubjectId implements Serializable {

    private String courseId, subjectId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseSubjectId that = (CourseSubjectId) o;
        return courseId.equals(that.courseId) &&
                subjectId.equals(that.subjectId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId, subjectId);
    }
}
