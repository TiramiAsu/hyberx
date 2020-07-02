package tw.com.hyberx.service.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.com.hyberx.model.dao.MemberDAO;
import tw.com.hyberx.model.entity.Member;
import tw.com.hyberx.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDAO memberDAO;
	
	@Override
	@Transactional
	public boolean create(Member bean) {
		bean.setTimeBuild(new Date());
        bean.setTimeModify(new Date());
        return memberDAO.save(bean);
	}
	
	@Override
	@Transactional
	public Member find(Long id) {
		// TODO Auto-generated method stub
		return memberDAO.find(id);
	}

	@Override
	@Transactional
	public boolean update(Member bean) {
		// TODO Auto-generated method stub
		return memberDAO.save(bean);
	}

	@Override
	@Transactional
	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		return memberDAO.remove(memberDAO.find(id));
	}

	@Override
	@Transactional
	public List<Member> query() {
		List<Member> memberList=null;
		
		try {
			memberList=memberDAO.findAll()
					.stream()
					.sorted((o1,o2)->o2.getId().compareTo
							(o1.getId()))
					.collect(Collectors.toList());
			if (memberList==null) {
				throw new Exception(">>> Member Query Failed <<<");
			}
		} catch (Exception e) {
			memberList=null;
			e.printStackTrace();
		}
		return memberList;
	}
	
}
