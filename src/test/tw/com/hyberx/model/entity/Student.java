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
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * [學生]
 * <p>
 * [ 新增 table ]
<pre>
CREATE TABLE public.student
(    
    id bigserial NOT NULL,
    PRIMARY KEY (id),
    name character varying(255),
    age int NOT NULL,
    time_build timestamp without time zone NOT NULL,
    time_modify timestamp without time zone NOT NULL
)
WITH (
    OIDS = FALSE
);

ALTER TABLE public.student
OWNER to postgres
</pre>
 * [ 新增 Data ]
<pre>
INSERT INTO public.student(id, name, age, time_build, time_modify) VALUES
(default, 'peter', 24, current_timestamp, current_timestamp),
(default, 'sandy', 22, current_timestamp, current_timestamp);
</pre>
 * @author  Asu
 * @since   2020-06-06 01:25
 * @version 
 */
@Entity
@Table(name = "student")
public class Student implements Serializable {

    private static final long serialVersionUID = -5608241289036967005L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "basicinfo_id")
    @JsonIgnoreProperties(value = {"student"})
    private BasicInfo basicInfo;

    @Column(name = "time_build", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeBuild;
    
    @Column(name = "time_modify", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeModify;
    
    public Student() {}

    public Student(BasicInfo basicInfo) {
        this.basicInfo = basicInfo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BasicInfo getBasicInfo() {
        return basicInfo;
    }

    public void setBasicInfo(BasicInfo basicInfo) {
        this.basicInfo = basicInfo;
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
        return "Student [id=" + id +
//                ", basicInfo=" + basicInfo.getName() +
        		", basicInfo=" + basicInfo +
                ", timeBuild=" + timeBuild +
                ", timeModify=" + timeModify +
                "]";
    }
}
