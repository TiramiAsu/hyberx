package tw.com.hyberx.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import tw.com.hyberx.model.dao.MemberDAO;
import tw.com.hyberx.model.entity.Member;
import tw.com.hyberx.service.MemberService;

public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDAO memberDAO;
	@Override
	public boolean create(Member bean) {
		bean.setTimeBuild(new Date());
        bean.setTimeModify(new Date());
        return memberDAO.save(bean);
	}

	@Override
	public List<Member> query() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member find(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Member bean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
