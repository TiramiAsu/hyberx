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
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * [學系]
 * <p>
 * 
 * @author  Asu
 * @since   2020-06-17 23:41
 * @version 
 */
//@Entity
//@Table(name = "department")
public class Department implements Serializable {

    private static final long serialVersionUID = -4336884726183375917L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "name", length = 255, nullable = false)
    private String name;

    private List<Student> students = new ArrayList<>();

    public Department(String name) {
        this.name = name;
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

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Department [id=" + id +
                ", name=" + name +
                "]";
    }
}
