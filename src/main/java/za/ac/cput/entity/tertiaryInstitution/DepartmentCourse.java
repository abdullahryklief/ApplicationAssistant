package za.ac.cput.entity.tertiaryInstitution;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.util.Objects;
@Entity
@IdClass(DepartmentCourseId.class)
public class DepartmentCourse {

    @Id
    private String departmentId, courseId;

    protected DepartmentCourse() {}

    private DepartmentCourse(Builder builder) {
        this.departmentId = builder.departmentId;
        this.courseId = builder.courseId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public String getCourseId() {
        return courseId;
    }

    @Override
    public String toString() {
        return "DepartmentCourse{" +
                "departmentId='" + departmentId + '\'' +
                ", courseId='" + courseId + '\'' +
                '}';
    }

    public static class Builder {
        private String departmentId, courseId;

        public Builder departmentId(String departmentId) {
            this.departmentId = departmentId;
            return this;
        }

        public Builder courseId(String courseId) {
            this.courseId = courseId;
            return this;
        }

        public Builder copy(DepartmentCourse departmentCourse) {
            this.departmentId = departmentCourse.departmentId;
            this.courseId = departmentCourse.courseId;
            return this;
        }

        public DepartmentCourse build(){
            return new DepartmentCourse(this);
        }
    }
}