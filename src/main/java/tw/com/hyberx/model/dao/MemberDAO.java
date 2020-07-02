package tw.com.hyberx.model.dao;

import com.googlecode.genericdao.dao.hibernate.GenericDAO;

import tw.com.hyberx.model.entity.Member;

public interface MemberDAO  extends _DAO<Member>, GenericDAO<Member, Long> {

	
}
