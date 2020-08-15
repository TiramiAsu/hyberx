/*
 * 
 * 
 * 
 * 
 * 
 * &copy;TiramiAsu
 * 
 */
package tw.com.hyberx.generic;

import java.util.List;

import tw.com.hyberx.utils.ResponseREST;

/**
 * <pre>
 * [定義 GenericService ] 2019-12-24 16:28
 * </pre>
 * 
 * @author TiramiAsu (Email)
 */
public interface GenericService<T> {

	// Basic
	public boolean create(T bean);
	public List<T> query();
	public T find(Long id);
	public boolean update(T bean);
	public boolean delete(Long id);

	// JSON
<<<<<<< HEAD
	ResponseREST queryREST(Object json);
=======
//	ResponseREST queryREST(Object json);
>>>>>>> bob
	
}
