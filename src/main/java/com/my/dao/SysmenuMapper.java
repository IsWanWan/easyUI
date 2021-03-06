package com.my.dao;

import com.my.domain.Sysmenu;


import java.util.List;

public interface SysmenuMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Sysmenu record);

    int insertSelective(Sysmenu record);

    Sysmenu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Sysmenu record);

    int updateByPrimaryKey(Sysmenu record);

    public List<Sysmenu> selectMenuList(int parentId);
}