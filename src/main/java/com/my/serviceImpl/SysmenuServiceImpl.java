package com.my.serviceImpl;

import com.my.dao.SysmenuMapper;
import com.my.domain.Sysmenu;
import com.my.service.SysmenuService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wanwan on 16/9/7.
 */
@Service
public class SysmenuServiceImpl implements SysmenuService {
    @Autowired
    private SysmenuMapper sysmenuMapper;
    @Override
    public int deleteByPrimaryKey(Long id) {
        return sysmenuMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Sysmenu record) {
        return sysmenuMapper.insert(record);
    }

    @Override
    public int insertSelective(Sysmenu record) {
        return sysmenuMapper.insertSelective(record);
    }

    @Override
    public Sysmenu selectByPrimaryKey(Long id) {
        return sysmenuMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Sysmenu record) {
        return sysmenuMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Sysmenu record) {
        return sysmenuMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Sysmenu> selectMenuList(int parentId) {
        return sysmenuMapper.selectMenuList(parentId);
    }
}
