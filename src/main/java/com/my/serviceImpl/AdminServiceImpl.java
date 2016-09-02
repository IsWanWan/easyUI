package com.my.serviceImpl;

import com.my.dao.AdminMapper;
import com.my.domain.Admin;
import com.my.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by wanwan on 16/8/26.
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;
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
   @Cacheable(value = "myCache",key="'admin'+#id")
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
}
