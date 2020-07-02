/*
 * 
 * 
 * 
 * 
 * 
 * &copy;Asu
 * 
 */
package tw.com.hyberx.controller.vo;

import tw.com.hyberx.model.entity.BasicInfo;
import tw.com.hyberx.model.entity.Student;

/**
 * [StudentVo]
 * <p>
 * 
 * @author  Asu
 * @since   2020-06-18 00:17
 * @version 
 */
public class StudentVo {

    private Student student;
    private BasicInfo basicInfo;

    public StudentVo() {
        BasicInfo basicInfo = new BasicInfo();
        this.student = new Student(basicInfo);
        this.basicInfo = basicInfo;
    }

    public StudentVo(Student student) {
        this.student = student;
        this.basicInfo = student.getBasicInfo();
    }

    public StudentVo(Student student, BasicInfo basicInfo) {
        student.setBasicInfo(basicInfo);
        this.student = student;
        this.basicInfo = basicInfo;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public BasicInfo getBasicInfo() {
        return basicInfo;
    }

    public void setBasicInfo(BasicInfo basicInfo) {
        this.basicInfo = basicInfo;
    }

    @Override
    public String toString() {
        return "StudentVo [student=" + student +
                ", basicInfo=" + basicInfo +
                "]";
    }
}
