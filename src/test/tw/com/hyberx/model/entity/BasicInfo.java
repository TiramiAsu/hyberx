/*
 * 
 * 
 * 
 * 
 * 
 * &copy;Asu
 * 
 */
package tw.com.hyberx.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * [基本資料]
 * <p>
 * 
 * @author  Asu
 * @since   2020-06-18 00:00
 * @version 
 */
@Entity
@Table(name = "basic_info")
public class BasicInfo implements Serializable {

    private static final long serialVersionUID = 6848014154586376321L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 255, nullable = false)
    private String name;

    @Column(name = "age", nullable = false)
    private Integer age;

    @OneToOne(mappedBy = "basicInfo", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonIgnoreProperties(value = {"basicInfo"})
    private Student student;

    @Column(name = "time_build", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeBuild;
    
    @Column(name = "time_modify", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeModify;

    public BasicInfo() {}

    public BasicInfo(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Date getTimeBuild() {
        return timeBuild;
    }

    public void setTimeBuild(Date timeBuild) {
        this.timeBuild = timeBuild;
    }

    public Date getTimeModify() {
        return timeModify;
    }

    public void setTimeModify(Date timeModify) {
        this.timeModify = timeModify;
    }

    @Override
    public String toString() {
        return "BasicInfo [id=" + id +
                ", name=" + name +
                ", age=" + age +
                ", student=" + student.getId() +
                ", timeBuild=" + timeBuild +
                ", timeModify=" + timeModify +
                "]";
    }
}
