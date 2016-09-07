package com.my.service;

import com.my.domain.Sysmenu;
import com.sun.tools.javac.util.List;

/**
 * Created by wanwan on 16/9/7.
 */
public interface SysmenuService {

    int deleteByPrimaryKey(Long id);

    int insert(Sysmenu record);

    int insertSelective(Sysmenu record);

    Sysmenu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Sysmenu record);

    int updateByPrimaryKey(Sysmenu record);


    List<Sysmenu> selectMenuList(int parentId);
}
