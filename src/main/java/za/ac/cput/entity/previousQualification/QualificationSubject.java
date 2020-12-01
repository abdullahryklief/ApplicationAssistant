

package za.ac.cput.entity.previousQualification;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;


@Entity
@IdClass(QualificationSubjectId.class)
public class QualificationSubject   {

    @Id
    private String QualificationId, SubjectId;


    protected QualificationSubject() {}

    public QualificationSubject(Builder builder) {
        this.QualificationId = builder.QualificationId;
        this.SubjectId = builder.SubjectId;
    }


    public String getQualificationId() {
        return QualificationId;
    }

    public String getSubjectId() {
        return SubjectId;
    }

    @Override
    public String toString() {
        return "QualificationSubject{" +
                "QualificationId='" + QualificationId + '\'' +
                ", SubjectId='" + SubjectId + '\'' +
                '}';
    }


    public static class Builder{

        private String QualificationId, SubjectId;

        public Builder setQualificationId(String qualificationId) {
            this.QualificationId = qualificationId;
            return this;
        }

        public Builder setSubjectId(String subjectId) {
            this.SubjectId = subjectId;
            return this;
        }



        public Builder copy(QualificationSubject qualiSub) {

            this.QualificationId = qualiSub.QualificationId;
            this.SubjectId = qualiSub.SubjectId;
            return this;

        }

        public QualificationSubject build(){
            return new QualificationSubject(this);
        }

    }

    }


