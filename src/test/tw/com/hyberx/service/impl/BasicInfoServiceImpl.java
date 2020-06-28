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

import tw.com.hyberx.model.dao.BasicInfoDAO;
import tw.com.hyberx.model.entity.BasicInfo;
import tw.com.hyberx.service.BasicInfoService;

/**
 * [titleBasicInfoServiceImpl]
 * <p>
 * 
 * @author  Asu
 * @since   2020-06-18 01:28
 * @version 
 */
@Service
public class BasicInfoServiceImpl implements BasicInfoService {

    @Autowired
    private BasicInfoDAO basicInfoDAO;

    @Override
    @Transactional
    public boolean create(BasicInfo bean) {
        bean.setTimeBuild(new Date());
        bean.setTimeModify(new Date());
        return basicInfoDAO.save(bean);
    }

    @Override
    @Transactional
    public BasicInfo find(Long id) {
        return basicInfoDAO.find(id);
    }

    @Override
    @Transactional
    public boolean update(BasicInfo bean) {
        return basicInfoDAO.save(bean);
    }

    @Override
    @Transactional
    public boolean delete(Long id) {
        return basicInfoDAO.remove(basicInfoDAO.find(id));
    }

    @Override
    @Transactional
    public List<BasicInfo> query() {

        List<BasicInfo> basicInfoList = null;

        /* Initial value */
        /* Check */
        /* Search Condition */

        try {
            basicInfoList = basicInfoDAO.findAll()
                    .stream()
                    .sorted((o1, o2) -> o2.getId().compareTo(o1.getId()))
                    // .peek(System.out::println)
                    .collect(Collectors.toList());
            if (basicInfoList == null) {
                throw new Exception(">>> BasicInfo Query Failed <<<");
            }
        } catch (Exception e) {
            basicInfoList = null;
            e.printStackTrace();
        }
        return basicInfoList;
    }
}
