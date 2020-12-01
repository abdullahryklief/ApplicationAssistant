package za.ac.cput.entity.tertiaryInstitution;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(CourseSubjectId.class)
public class CourseSubject {

    @Id
    private String courseId, subjectId;

    protected CourseSubject(){}

    private CourseSubject(Builder builder){
        this.courseId = builder.courseId;
        this.subjectId = builder.subjectId;
    }

    public String getCourseId(){
        return courseId;
    }

    public String getSubjectId(){
        return subjectId;
    }

    @Override
    public String toString() {
        return "CourseSubject{" +
                "courseId='" + courseId + '\'' +
                ", subjectId='" + subjectId + '\'' +
                '}';
    }

    public static class Builder {
        private String courseId, subjectId;

        public Builder courseId(String courseId){
            this.courseId = courseId;
            return this;

        }

        public Builder subjectId(String subjectId){
            this.subjectId = subjectId;
            return this;
        }

        public Builder copy(CourseSubject courseSubject){
            this.courseId = courseSubject.courseId;
            this.subjectId = courseSubject.subjectId;
            return this;
        }

        public CourseSubject Build(){
            return new CourseSubject( this);
        }
    }
}
