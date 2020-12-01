package za.ac.cput.entity.tertiaryInstitution;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(FacultyDepartmentId.class)
public class FacultyDepartment {
    @Id
    private String facultyId, departmentId;

    protected FacultyDepartment() {}

    private FacultyDepartment(Builder builder) {
        this.facultyId = builder.facultyId;
        this.departmentId = builder.departmentId;
    }

    public String getFacultyId() {
        return facultyId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    @Override
    public String toString() {
        return "FacultyDepartment{" +
                "facultyId='" + facultyId + '\'' +
                ", departmentId='" + departmentId + '\'' +
                '}';
    }

    public static class Builder {
        private String facultyId, departmentId;

        public Builder facultyId(String facultyId) {
            this.facultyId = facultyId;
            return this;
        }

        public Builder departmentId(String departmentId) {
            this.departmentId = departmentId;
            return this;
        }

        public Builder copy(FacultyDepartment facultyDepartment) {
            this.facultyId = facultyDepartment.facultyId;
            this.departmentId = facultyDepartment.departmentId;
            return this;
        }

        public FacultyDepartment build() { return new FacultyDepartment(this);}
    }
}
