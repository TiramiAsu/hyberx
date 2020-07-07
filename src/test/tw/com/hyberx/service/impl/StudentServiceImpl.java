/*
 * 
 * 
 * 
 * 
 * 
 * &copy;Asu
 * 
 */
package tw.com.hyberx.service.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.com.hyberx.model.dao.StudentDAO;
import tw.com.hyberx.model.entity.Student;
import tw.com.hyberx.service.StudentService;
import tw.com.hyberx.utils.ResponseREST;

/**
 * [StudentServiceImpl]
 * <p>
 * 
 * @author Asu
 * @since 2020-06-13 16:16
 * @version
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDAO studentDAO;

    @Override
    @Transactional
    public boolean create(Student bean) {
        bean.setTimeBuild(new Date());
        bean.setTimeModify(new Date());
        return studentDAO.save(bean);
    }

    @Override
    @Transactional
    public Student find(Long id) {
        return studentDAO.find(id);
    }

    @Override
    @Transactional
    public boolean update(Student bean) {
        return studentDAO.save(bean);
    }

    @Override
    @Transactional
    public boolean delete(Long id) {
        return studentDAO.remove(studentDAO.find(id));
    }

    @Override
    @Transactional
    public List<Student> query() {

        List<Student> studentList = null;

        /* Initial value */
        /* Check */
        /* Search Condition */

        try {
            studentList = studentDAO.findAll()
                    .stream()
                    .sorted((o1, o2) -> o2.getId().compareTo(o1.getId()))
                    // .peek(System.out::println)
                    .collect(Collectors.toList());
            if (studentList == null) {
                throw new Exception(">>> Student Query Failed <<<");
            }
        } catch (Exception e) {
            studentList = null;
            e.printStackTrace();
        }
        return studentList;
    }

	@Override
	public ResponseREST queryREST(Object json) {
		// TODO Auto-generated method stub
		return null;
	}
}
