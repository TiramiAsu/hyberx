/*
 * 
 * 
 * 
 * 
 * 
 * &copy;Asu
 * 
 */
package tw.com.hyberx.model.dao;

import com.googlecode.genericdao.dao.hibernate.GenericDAO;

import tw.com.hyberx.model.entity.Student;

/**
 * [StudentDAO]
 * <p>
 * 
 * @author  Asu
 * @since   2020-06-13 16:03
 * @version 
 */
public interface StudentDAO extends _DAO<Student>, GenericDAO<Student, Long> {}
