package com.my.serviceImpl;

import com.my.dao.AdminMapper;
import com.my.dao.SysmenuMapper;
import com.my.domain.Admin;
import com.my.domain.Sysmenu;
import com.my.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by wanwan on 16/8/26.
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private SysmenuMapper sysmenuMapper;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return adminMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Admin record) {
        return 0;
    }

    @Override
    public int insertSelective(Admin record) {
        return adminMapper.insertSelective(record);
    }

    @Override
    public Admin selectByPrimaryKey(Integer id) {

        return adminMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Admin record) {
        return adminMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Admin record) {
        return 0;
    }

    /***
     * listPage
     *
     * @param map
     */
    @Override
    public List<Admin> listPage(Map map) {
        return adminMapper.listPage(map);
    }

    @Override
    public int totalPage(Map map) {
        return adminMapper.totalPage(map);
    }

    @Override
    @Transactional(rollbackFor=Exception.class)
    public int insertTrans() {
        Sysmenu sysmenu = new Sysmenu("DD","添加账号","dfsdf",(long)16,"icon-add",2,1,new Date(),1);
      int n=   sysmenuMapper.insertSelective(sysmenu);
        Admin admin = new Admin();
        admin.setAddress("dfdf");
        admin.setUsername("王哈哈");
        admin.setPassword("12322");
        int m  = insertSelective(admin);
        return n;
    }


}
